package com.example.shopping.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.shopping.entities.Product;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerFunctionalTest {

    @Autowired
    private WebTestClient client;

    @Test
    void testGetAllProducts() {
        client.get()
                .uri("/products")
                .exchange()
                .expectBodyList(Product.class)
                .hasSize(3)
                .consumeWith(System.out::println);
    }

    @Test
    void testGetProductById() {

    }
}
