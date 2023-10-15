package com.example.shopping.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void findAllByPriceLessThanEqual() {
        var products = repository.findAllByPriceLessThanEqual(BigDecimal.valueOf(20.00));
        products.forEach(System.out::println);
        assertEquals(2, products.size());
    }
}
