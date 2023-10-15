package com.example.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.entities.Product;
import com.example.shopping.services.ProductService;

@RestController
public class ProductController {
    
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
}
