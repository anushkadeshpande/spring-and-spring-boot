package com.example.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
