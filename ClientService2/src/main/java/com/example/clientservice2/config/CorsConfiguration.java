package com.example.clientservice2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.hibernate.CacheMode.PUT;

@Configuration
public class CorsConfiguration {
    private static final String GET = "GET";
    private static final String POST = "POST";

    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";
    @Bean
    public WebMvcConfigurer corsConfugurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods(GET, POST, DELETE,PUT)
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);
            }
        };
    }
    /*
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();

        // Configurations CORS
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedMethod("DELETE"); // Autoriser la méthode DELETE
        config.addAllowedMethod("GET"); // Autoriser la méthode DELETE
        config.addAllowedMethod("POST"); // Autoriser la méthode DELETE
        config.addAllowedMethod("PUT"); // Autoriser la méthode DELETE
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod(HttpMethod.OPTIONS);
        // Autres configurations CORS (allowedMethods, allowedHeaders, etc.)
        config.addAllowedHeader("Origin");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Authorization");


        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }*/
  /*@Bean
  public RestTemplate restTemplate() {
      return new RestTemplate();
  }*/
}

