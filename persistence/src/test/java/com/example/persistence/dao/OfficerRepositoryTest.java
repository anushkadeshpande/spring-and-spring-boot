package com.example.persistence.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.persistence.entities.Officer;

import jakarta.transaction.Transactional;

@SpringBootTest
public class OfficerRepositoryTest {
    @Autowired
    private OfficerRepository repository;

    @Autowired
    private JdbcTemplate template;

    private List<Integer> getIds() {
        return template.query("select id from officers", (resultSet, num) -> resultSet.getInt("id"));
    } 
    
    @Test
    void findAllOfficers() {
        var officers = repository.findAll();
        System.out.println(officers);
        assertEquals(5,officers.size());
    }

    @Test
    void findById() {

        getIds().forEach(id -> {
            Optional<Officer> officer = repository.findById(id);
            System.out.println(officer);
            assertTrue(officer.isPresent());
        });

    }

    // in a test @Transactional rolls back the transaction automatically
    @Test
    @Transactional
    void deleteAll() {
        repository.deleteAll();
        assertEquals(0, repository.count());
    }
}
