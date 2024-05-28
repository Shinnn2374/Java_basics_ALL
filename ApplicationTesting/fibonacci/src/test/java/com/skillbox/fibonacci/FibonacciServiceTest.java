package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class FibonacciServiceTest {

    private FibonacciService service;

    private final FibonacciRepository repository = Mockito.mock(FibonacciRepository.class);

    private final FibonacciCalculator calculator = Mockito.mock(FibonacciCalculator.class);

    @BeforeEach
    public void setUp(){
         service = new FibonacciService(repository,calculator);
    }

    @Test
    @DisplayName("Test of take from data base")
    public void testOfTakeFromDataBase(){
        int index = 8;
        FibonacciNumber check = new FibonacciNumber();
        check.setIndex(index);
        when(repository.save(check)).thenReturn(check);
        assertEquals(index, service.fibonacciNumber(index).getIndex());
        verify(repository,times(1)).findByIndex(index);
    }

    @Test
    @DisplayName("Test of calculate new number")
    public void testOfCalculateNewNumber(){
        int index = 34;
        FibonacciNumber number = new FibonacciNumber();
        number.setIndex(index);
        assertFalse(repository.findByIndex(index).isPresent());
    }

    @Test
    @DisplayName("Test of throws exception")
    public void testOfThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.fibonacciNumber(-1) );
    }

}
