package com.example.shopping.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // no need to write an implementation of this method
    // since it follows the naming convention, Spring Data JPA will itself generate the implementation
    List<Product> findAllByPriceLessThanEqual(BigDecimal price);
}
