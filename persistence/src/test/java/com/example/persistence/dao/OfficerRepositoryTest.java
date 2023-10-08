package com.example.persistence.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
