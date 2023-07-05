package com.spring.helloworld.helloworld;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Value;
import com.google.api.services.calendar.Calendar.Events;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomepageController {
        private final static Log logger = LogFactory.getLog(HomepageController.class);
        private static final String APPLICATION_NAME = "Google Calendar App test";
        private static HttpTransport httpTransport;
        private static final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        private static com.google.api.services.calendar.Calendar client;

        GoogleClientSecrets clientSecrets;
        GoogleAuthorizationCodeFlow flow;
        Credential credential;

        @Value("${spring.security.oauth2.client.registration.google.client-id}")
        private String clientId;
        @Value("${spring.security.oauth2.client.registration.google.client-secret}")
        private String clientSecret;
        @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
        private String redirectURI;

        private Set<Event> events = new HashSet<>();

        final DateTime date1 = new DateTime("2017-05-05T16:30:00.000+05:30");
        final DateTime date2 = new DateTime(new Date());

        public void setEvents(Set<Event> events) {
            this.events = events;
        }

        @RequestMapping(value = "/login/google", method = RequestMethod.GET)
        public RedirectView googleConnectionStatus(HttpServletRequest request) throws Exception {
            return new RedirectView(authorize());
        }

        @RequestMapping(value = "/login/google", method = RequestMethod.GET, params = "code")
        public ResponseEntity<String> oauth2Callback(@RequestParam(value = "code") String code) {
            com.google.api.services.calendar.model.Events eventList;
            String message;
            try {
                TokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectURI).execute();
                credential = flow.createAndStoreCredential(response, "140204458989-37s2vqpr331nrsg4scv2jra0e7qf6r4s.apps.googleusercontent.com");
                client = new com.google.api.services.calendar.Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                        .setApplicationName(APPLICATION_NAME).build();
                Events events = client.events();
                eventList = events.list("primary").setTimeMin(date1).setTimeMax(date2).execute();
                message = eventList.getItems().toString();
                System.out.println("My:" + eventList.getItems());
            } catch (Exception e) {
                logger.warn("Exception while handling OAuth2 callback (" + e.getMessage() + ")."
                        + " Redirecting to google connection status page.");
                message = "Exception while handling OAuth2 callback (" + e.getMessage() + ")."
                        + " Redirecting to google connection status page.";
            }

            System.out.println("cal message:" + message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        public Set<Event> getEvents() throws IOException {
            return this.events;
        }

        private String authorize() throws Exception {
            AuthorizationCodeRequestUrl authorizationUrl;
            if (flow == null) {
                Details web = new Details();
                web.setClientId(clientId);
                web.setClientSecret(clientSecret);
                clientSecrets = new GoogleClientSecrets().setWeb(web);
                httpTransport = GoogleNetHttpTransport.newTrustedTransport();
                flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets,
                        Collections.singleton(CalendarScopes.CALENDAR)).build();
            }
            authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectURI);
            System.out.println("cal authorizationUrl->" + authorizationUrl);
            return authorizationUrl.build();
        }
  /*  @Value("${CALENDAR_ID}")
    private String CALENDAR_ID;
    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public ResponseEntity<String> showCalendar() {
        String message;
        try {
            com.google.api.services.calendar.model.Events eventList = client.events()
                    .list(CALENDAR_ID)
                    .setTimeMin(date1)
                    .setTimeMax(date2)
                    .execute();
            events = new HashSet<>(eventList.getItems());
            message = events.toString();
        } catch (IOException e) {
            logger.warn("Exception while retrieving events from Google Calendar (" + e.getMessage() + ").");
            message = "Exception while retrieving events from Google Calendar (" + e.getMessage() + ").";
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }*/

}


