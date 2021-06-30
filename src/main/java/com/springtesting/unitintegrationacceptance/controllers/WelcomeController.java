package com.springtesting.unitintegrationacceptance.controllers;

import com.springtesting.unitintegrationacceptance.service.WelcomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {

    private WelcomeService welcomeService;

    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "Jiten") String name){
        return welcomeService.welcome(name);
    }
}