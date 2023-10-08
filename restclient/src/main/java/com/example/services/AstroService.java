package com.example.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AstroService {

    // webclient is not a managed bean
    private final WebClient client = WebClient.create("http://api.open-notify.org");
    private final RestTemplate template;

    public AstroService(RestTemplateBuilder builder)  {
        template = builder.build();
    }
}
