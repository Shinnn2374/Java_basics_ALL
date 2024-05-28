package com.skillbox.fibonacci;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static junit.framework.TestCase.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {

    @Autowired
    FibonacciRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;

    TestRestTemplate template = new TestRestTemplate();

    @BeforeAll
    public static void beforeAll(){
        postgres.start();
    }

    @AfterAll
    public static void afterAll(){
        postgres.stop();
    }

    @Test
    @DisplayName("Test repository saving")
    public void testRepositorySaving(){
        FibonacciNumber number = new FibonacciNumber();
        number.setIndex(45);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);
        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 45",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        assertFalse(actual.isEmpty());
    }

    @Test
    @DisplayName("Test get number from DB")
    public void testGetNumberFromDB(){
        FibonacciNumber number = new FibonacciNumber();
        number.setIndex(6);
        repository.save(number) ;
        entityManager.flush();
        entityManager.detach(number);
        assertFalse(repository.findByIndex(6).isEmpty());
    }

    @Test
    @DisplayName("Test exception")
    public void testGetException(){
        boolean exceptionThrows = false;
        try {
            int exSize = 1;
            FibonacciNumber number1 = new FibonacciNumber(1,1);
            FibonacciNumber number2 = new FibonacciNumber(1,1);
            repository.save(number1);
            entityManager.flush();
            repository.save(number2);
            entityManager.flush();
            entityManager.detach(number1);
            entityManager.detach(number2);
            List<FibonacciNumber> actual = jdbcTemplate.query(
                    "SELECT * FROM fibonacci_number WHERE index = 45",
                    (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
            );
            assertEquals(exSize, actual.size());
    }catch (Exception e){
            exceptionThrows = true;
        }
        assertTrue(exceptionThrows);
    }
}
