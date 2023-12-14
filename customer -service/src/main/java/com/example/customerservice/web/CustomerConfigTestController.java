package com.example.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@PropertySource("file:///D:/IdeaProjects/ecom-emsi/Config-repo/application.properties")

public class CustomerConfigTestController {
    @Value("${customer.params.p1}")
    private String p1;

    @GetMapping("/test")
    public String test() {
        return "P1 value: " + p1;
    }

    @Value("${customer.params.x}")
    private String x;

    @Value("${global.params.x}")
    private String globalX;

    @Value("${global.params.y}")
    private String globalY;

    @GetMapping("/params")
    public Map<String, String> params() {
        return Map.of("p1", p1, "x", x, "globalX", globalX, "globalY", globalY);
    }

}
