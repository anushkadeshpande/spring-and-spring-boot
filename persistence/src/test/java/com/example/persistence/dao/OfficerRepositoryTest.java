package com.example.persistence.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.persistence.entities.Officer;

import jakarta.transaction.Transactional;

@SpringBootTest
public class OfficerRepositoryTest {
    @Autowired
    private OfficerRepository repository;
    
    @Test
    void findAllOfficers() {
        var officers = repository.findAll();
        System.out.println(officers);
        assertEquals(5,officers.size());
    }

    @Test
    void findById() {
        Optional<Officer> officer = repository.findById(1);
        System.out.println(officer);
        assertTrue(officer.isPresent());
    }

    // in a test @Transactional rolls back the transaction automatically
    @Test
    @Transactional
    void deleteAll() {
        repository.deleteAll();
        assertEquals(0, repository.count());
    }
}
