package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerMockMVCTest {
    
    @Autowired
    private MockMvc mvc;

    // to check if the mvc object is autowired correctly
    @Test
    public void autowiringWorked() {
        assertNotNull(mvc);
    }

    @Test
    public void testHelloWithoutName() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
           .andExpect(status().isOk())
           .andExpect(view().name("hello"))
           .andExpect(model().attribute("user", "world"));
    }

    @Test
    public void testHelloWithName() throws Exception {
        mvc.perform(get("/hello").param("name", "Anna").accept(MediaType.TEXT_HTML))
           .andExpect(status().isOk())
           .andExpect(view().name("hello"))
           .andExpect(model().attribute("user", "Anna"));
    }
}
