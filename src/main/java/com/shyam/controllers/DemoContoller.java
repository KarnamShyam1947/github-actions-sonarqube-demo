package com.shyam.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoContoller {

    Logger logger = LoggerFactory.getLogger(DemoContoller.class);

    @Value("${spring.application.name}")
    private String appName;
    
    @GetMapping("/")
    public Object sample() {
        return Map.of("name", "karnam shyam",
                      "app-name", appName,
                      "email", "karnamshyam9009@gmail.com");
    }
    
    @GetMapping("/testing")
    public Object sampleTest() {
        logger.warn("Testing warn logs....");
        return Map.of("testing", "okk");
    }

}
