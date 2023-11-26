package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.Filter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Configurations CORS
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // Remplacez par vos origines autorisées
        config.addAllowedMethod("DELETE"); // Autoriser la méthode DELETE
        config.addAllowedMethod("GET"); // Autoriser la méthode DELETE
        config.addAllowedMethod("POST"); // Autoriser la méthode DELETE
        config.addAllowedMethod("PUT"); // Autoriser la méthode DELETE
        // Autres configurations CORS (allowedMethods, allowedHeaders, etc.)
        config.addAllowedHeader("Origin");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Authorization");


        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
