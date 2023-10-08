package com.example.restclient.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AstroServiceTest {

    @Autowired
    private AstroService service;

    @Test
    void testGetAstronauts() {
        String json = service.getAstronauts();
        System.out.println(json);
        assertTrue(json.contains("success"));
    }
}
