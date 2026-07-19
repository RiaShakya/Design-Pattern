package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // Tests add() method using assertEquals()
    @Test
    void testAdd() {

        Calculator calculator = new Calculator();

        int result = calculator.add(10, 5);

        assertEquals(15, result);
    }

    // Tests subtract() method using assertEquals()
    @Test
    void testSubtract() {

        Calculator calculator = new Calculator();

        int result = calculator.subtract(10, 5);

        assertEquals(5, result);
    }

    // Tests multiply() method using assertEquals()
    @Test
    void testMultiply() {

        Calculator calculator = new Calculator();

        int result = calculator.multiply(4, 5);

        assertEquals(20, result);
    }

    // Tests divide() method using assertEquals()
    @Test
    void testDivide() {

        Calculator calculator = new Calculator();

        int result = calculator.divide(20, 4);

        assertEquals(5, result);
    }

    // Tests isEven() method for an even number
    // Uses assertTrue()
    @Test
    void testIsEvenForEvenNumber() {

        Calculator calculator = new Calculator();

        boolean result = calculator.isEven(8);

        assertTrue(result);
    }

    // Tests isEven() method for an odd number
    // Uses assertFalse()
    @Test
    void testIsEvenForOddNumber() {

        Calculator calculator = new Calculator();

        boolean result = calculator.isEven(7);

        assertFalse(result);
    }

    // Tests that add() does NOT return an incorrect value
    // Uses assertNotEquals()
    @Test
    void testAddNotEquals() {

        Calculator calculator = new Calculator();

        int result = calculator.add(10, 5);

        assertNotEquals(20, result);
    }

    // Tests divide() method with zero
    // Uses assertThrows()
    @Test
    void testDivideByZeroThrowsException() {

        Calculator calculator = new Calculator();

        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }

    // Tests divide() method with valid values
    // Uses assertDoesNotThrow()
    @Test
    void testDivideDoesNotThrowException() {

        Calculator calculator = new Calculator();

        assertDoesNotThrow(
                () -> calculator.divide(10, 2)
        );
    }

    // NEW TEST
    // Tests findMax() method
    // Uses assertEquals()
    @Test
    void testFindMax() {

        Calculator calculator = new Calculator();

        int result = calculator.findMax(10, 20);

        assertEquals(20, result);
    }
}