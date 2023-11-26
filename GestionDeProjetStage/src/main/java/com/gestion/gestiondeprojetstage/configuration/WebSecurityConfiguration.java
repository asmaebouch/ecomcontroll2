package com.gestion.gestiondeprojetstage.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration
{
    @Autowired
    private JwtAuthnticationEntryPoint jwtAuthnticationEntryPoint;
@Autowired
private JwtRequestFilter jwtRequestFilter;
@Autowired
private UserDetailsService jwtService;




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/authenticate", "/registerNewUser", "/roles").permitAll()
                                .requestMatchers((HttpHeaders.ALLOW)).permitAll()
                                .anyRequest().authenticated()
                )
                .exceptionHandling(customizer -> customizer.authenticationEntryPoint(jwtAuthnticationEntryPoint))
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
public PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
}
@Autowired
public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
}


}
