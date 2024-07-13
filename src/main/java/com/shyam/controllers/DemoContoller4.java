package com.shyam.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3")
public class DemoContoller4 {

    @Value("${spring.application.name}")
    private String appName;
    
    @GetMapping("/")
    public Object sample() {
        return Map.of("name", "karnam shyam",
                      "app-name", appName,
                      "email", "karnamshyam9009@gmail.com");
    }

}
