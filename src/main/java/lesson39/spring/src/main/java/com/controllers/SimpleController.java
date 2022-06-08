package com.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String homePage() {
        return appName + "<br><a href='http://localhost:8081/logout'>http://localhost:8081/logout</a>";
    }
}
