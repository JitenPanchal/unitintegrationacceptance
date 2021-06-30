package com.springtesting.unitintegrationacceptance.controllers;

import com.springtesting.unitintegrationacceptance.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WelcomeControllerUnitTest {

    @Test
    void shouldWelcome() {

        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        when(welcomeService.welcome(ArgumentMatchers.any())).thenReturn("Welcome JitenJiten!");

        WelcomeController welcomeController = new WelcomeController(welcomeService);
        assertEquals("Welcome JitenJiten!", welcomeController.welcome("Jiten"));
    }
}