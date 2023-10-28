package com.example.shopping.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.shopping.entities.Product;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerFunctionalTest {

    @Autowired
    private WebTestClient client;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @LocalServerPort
    int port;

    private List<Integer> getIds() {
        return jdbcTemplate.queryForList("SELECT id FROM product", Integer.class);
    }

    @Test
    void printPort() {
        assertNotNull(port);
        System.out.println("APPLICATION IS RUNNING ON PORT: "+ port);
    }

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
        getIds().forEach(id -> client.get()
                .uri("/products/{id}", id)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Product.class)
                .consumeWith(System.out::println));
    }
}
