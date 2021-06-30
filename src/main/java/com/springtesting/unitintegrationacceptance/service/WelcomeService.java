package com.springtesting.unitintegrationacceptance.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String welcome(String name){
        return String.format("Welcome %s!", name);
    }
}
