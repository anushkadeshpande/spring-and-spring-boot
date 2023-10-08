package com.example.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persistence.entities.Officer;

public interface OfficerRepository extends JpaRepository<Officer, Integer>{
    
}
