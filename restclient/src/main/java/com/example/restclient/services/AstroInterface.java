package com.example.restclient.services;

import org.springframework.web.service.annotation.GetExchange;

import com.example.restclient.json.AstroResponse;

public interface AstroInterface {
    
    @GetExchange("/astros.json")
    AstroResponse getAstroResponse();
}
