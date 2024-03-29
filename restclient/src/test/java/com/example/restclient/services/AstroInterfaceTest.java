package com.example.restclient.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restclient.json.AstroResponse;

@SpringBootTest
public class AstroInterfaceTest {

    private final Logger log = LoggerFactory.getLogger(AstroInterfaceTest.class);

    @Autowired
    private AstroInterface service;

    @Test
    void testGetAstroResponse() {
        AstroResponse response = service.getAstroResponse();
        log.info(response.toString());
        assertEquals("success", response.message());
    }
}
