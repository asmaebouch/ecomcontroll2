package ma.securetest.securetest.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {
    private JwtEncoder jwtEncoder;
    private JwtDecoder jwtDecoder;
    private UserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;
    public AuthController(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, UserDetailsService userDetailsService, AuthenticationManager authenticationManager){
        this.jwtEncoder=jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }
    /*
    * Pour s'aaautheentifier il eexistee deux
    *soit mdp
    * soit reefreshtoken
    * si mdp =>je connaais username te mdp
    *je peux recupere lee subject et scope
    * si refreshtoken=>decoder refeshtoken je recupere subjeect
    * ete pour les aauthoritie il faut que je chargee l'user
    * */


    @PostMapping("/token")
    public ResponseEntity<Map<String,String>> jwtToken(String grantType, String username , String password, boolean withRefreshToken, String refreshToken){
      String subject =null;
      String scope=null;

        if(grantType.equals("password")) {
            Authentication    authentication = authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(username, password)
     );
            subject=authentication.getName();
            scope= authentication.getAuthorities()
                    .stream().
                    map(aut-> aut.getAuthority()).
                    collect(Collectors.joining(" "));//return une collection de tyepee Granted authority

        }
        else if (grantType.equals("refreshToken")) {
            if(refreshToken==null){
                //Exception
                return new ResponseEntity<>(Map.of("errorMessage","Refresh Tokeen is required"), HttpStatus.UNAUTHORIZED);
            }
            Jwt decodeJwt= null;
            try {
                decodeJwt = jwtDecoder.decode(refreshToken);
            } catch (JwtException e) {
                return new ResponseEntity<>(Map.of("errorMessage",e.getMessage()), HttpStatus.UNAUTHORIZED);

            }
            subject =decodeJwt.getSubject();
            UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            //apartir de refreshtoken je conne le username
            //scopee howa le role
        scope=
               authorities.stream().map(auth->auth.getAuthority()).collect(Collectors.joining(" "));
        }
        Map<String ,String> iddToken=new HashMap<>();
        Instant instant=Instant.now();
            JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(withRefreshToken?5:30, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("scope",scope)
                .build();//reepresentre useer name dik subjetxt
        String  jwtAccessToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        iddToken.put("accessTokn",jwtAccessToken);
        if (withRefreshToken){
            JwtClaimsSet jwtClaimsSetRefresh=JwtClaimsSet.builder()
                    .subject(subject)
                    .issuedAt(instant)
                    .expiresAt(instant.plus(30, ChronoUnit.MINUTES))
                    .issuer("security-service")
                    .build();//reepresentre useer name dik subjetxt
            String  jwtRefreshToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
            iddToken.put("refreshToken",jwtRefreshToken);
        }
        return new ResponseEntity<>(iddToken,HttpStatus.OK);
    }

//expirer db 5assni neenvoyeer accees ou ana kansift refre
    }

