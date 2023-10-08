package com.example.restclient.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.restclient.json.AstroResponse;

@SpringBootTest
public class AstroServiceTest {

    private final Logger log = LoggerFactory.getLogger(AstroServiceTest.class);

    @Autowired
    private AstroService service;

    @Test
    void testGetAstronauts() {
        String json = service.getAstronauts();
        log.info(json);
        assertTrue(json.contains("success"));
    }

    @Test
    void testGetAstroResponse() {
        var response = service.getAstroResponse();
        log.info(response.toString());
        assertEquals("success", response.message());        
    }

    @Test
    void testGetAstroResponseEntity() {
        ResponseEntity<AstroResponse> response = service.getAstroResponseEntity();
        log.info(response.toString());
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody().message());
    }

    @Test
    void testGetAstroResponseRestTemplate() {
        var response = service.getAstroResponse();
        log.info(response.toString());
        assertEquals("success", response.message()); 
    }

    
}
