package com.skillbox.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class  FibonacciCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {8,9,10})
    @DisplayName("Test Fibonacci calculator")
    public void testOfCalculator(int num){
        FibonacciCalculator calculator = new FibonacciCalculator();
        int value = calculator.getFibonacciNumber(num);
        Assertions.assertEquals(value, 21,34);
    }

    @Test
    @DisplayName("Test of throws exception")
    public void testOfThrows() throws  IllegalArgumentException{
        FibonacciCalculator calculator = new FibonacciCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.getFibonacciNumber(0) );
    }

    @Test
    @DisplayName("Test for index 1 and 2")
    public void testForIndexOneAndTwo(){
        FibonacciCalculator calculator = new FibonacciCalculator();
        int firstValue = calculator.getFibonacciNumber(1);
        int secondValue = calculator.getFibonacciNumber(2);
        assertEquals(1,firstValue);
        assertEquals(1,secondValue);
    }
}
