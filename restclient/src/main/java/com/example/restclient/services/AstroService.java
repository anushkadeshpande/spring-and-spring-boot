package com.example.restclient.services;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.restclient.json.AstroResponse;

@Service
public class AstroService {

    // webclient is not a managed bean
    private final WebClient client = WebClient.create("http://api.open-notify.org");
    private final RestTemplate template;

    public AstroService(RestTemplateBuilder builder)  {
        template = builder.build();
    }

    public AstroResponse getAstroResponseRestTemplate() {
        return template.getForObject("http://api.open-notify.org/astros.json", AstroResponse.class);
    }

    public String getAstronauts() {
        return client.get()
                .uri("/astros.json")
                .retrieve()
                .bodyToMono(String.class)  // take the response body and convert to Mono
                .block(Duration.ofSeconds(2));
    }

    public AstroResponse getAstroResponse() {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/astros.json").build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .block(Duration.ofSeconds(2));
    }

    public ResponseEntity<AstroResponse> getAstroResponseEntity() {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/astros.json").build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(AstroResponse.class)
                .block(Duration.ofSeconds(2));
    }
}
