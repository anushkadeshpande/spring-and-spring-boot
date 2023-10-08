package com.example.restclient.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.restclient.json.AstroResponse;

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

    @Test
    void testGetAstroResponse() {
        var response = service.getAstroResponse();
        System.out.println(response);
        assertEquals("success", response.getMessage());        
    }

    @Test
    void testGetAstroResponseEntity() {
        ResponseEntity<AstroResponse> response = service.getAstroResponseEntity();
        System.out.println(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody().getMessage());
    }

    
}
