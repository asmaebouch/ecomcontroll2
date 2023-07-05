package com.spring.helloworld.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping(value = "/")
    public String helloWold(){
        return
                "Hello World from Spring Boot";
    }
    @RequestMapping(value = "/goodbye")
    public String goodbyee(){
        return "Goodbyee from Spring boot";
    }
}
