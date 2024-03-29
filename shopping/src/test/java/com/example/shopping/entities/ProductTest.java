package com.example.shopping.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.Validator;

@SpringBootTest
public class ProductTest {

    @Autowired
    private Validator validator;

    @Test
    void blankNameIsNotValid() {
        Product product = new Product("  ", BigDecimal.ONE);
        var violations = validator.validate(product);

        assertEquals(1, violations.size());        
        assertEquals("Name is required", violations.iterator().next().getMessage());
    }

    @Test
    void priceMustBePositiveOrZero() {
        Product product = new Product("Test", BigDecimal.valueOf(-1));
        var violations = validator.validate(product);

        assertEquals(1, violations.size());        
        assertEquals("Price must be positive or zero", violations.iterator().next().getMessage());
    }

    @Test
    void priceMustNotBeNull() {
        Product product = new Product("Test", null);
        var violations = validator.validate(product);

        assertEquals(1, violations.size());        
        assertEquals("Price is required", violations.iterator().next().getMessage());
    }
}
