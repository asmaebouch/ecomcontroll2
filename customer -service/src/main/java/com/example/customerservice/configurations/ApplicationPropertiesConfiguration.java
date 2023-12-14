package com.example.customerservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties("mes-configs")
public class ApplicationPropertiesConfiguration {
private int limitCustomers;
public int getLimitCustomers(){
    return limitCustomers;
}
public void setLimitCustomers(int limitCustomers){
    this.limitCustomers=limitCustomers;
}


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}


