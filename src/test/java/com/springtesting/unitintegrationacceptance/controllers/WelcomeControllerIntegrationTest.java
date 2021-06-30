package com.springtesting.unitintegrationacceptance.controllers;

import com.springtesting.unitintegrationacceptance.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WelcomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WelcomeService welcomeService;

    @Test
    void shouldWelcome() throws Exception {
        when(welcomeService.welcome(ArgumentMatchers.any())).thenReturn("Welcome JitenJiten!");

        WelcomeController welcomeController = new WelcomeController(welcomeService);

        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
        .andExpect(content().string(equalTo("Welcome JitenJiten!")));

        verify(welcomeService).welcome("Jiten");

    }

    @Test
    void shouldWelcome2() throws Exception {
        when(welcomeService.welcome(ArgumentMatchers.any())).thenReturn("Welcome panchal!");

        WelcomeController welcomeController = new WelcomeController(welcomeService);

        mockMvc.perform(get("/welcome?name=panchal"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome panchal!")));

        verify(welcomeService).welcome("panchal");

    }
}