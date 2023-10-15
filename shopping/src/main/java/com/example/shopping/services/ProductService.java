package com.example.shopping.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.dao.ProductRepository;
import com.example.shopping.entities.Product;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> initializeDatabase() {
        List<Product> products = List.of(
                new Product("A", BigDecimal.valueOf(25.00)),
                new Product("B", BigDecimal.valueOf(10.00)),
                new Product("C", BigDecimal.valueOf(15.00)));
        return productRepository.saveAll(products);
    }
}
