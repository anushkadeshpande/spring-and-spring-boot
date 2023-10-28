package com.example.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.entities.Product;
import com.example.shopping.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        // return service.getProductById(id)
        // .map(ResponseEntity::ok)
        // .orElse(ResponseEntity.notFound().build());

        return ResponseEntity.of(service.getProductById(id));
    }
}
