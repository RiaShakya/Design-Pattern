package org.example;

public class Calculator {

    // Adds two numbers and returns the result
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts second number from first number
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplies two numbers and returns the result
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divides first number by second number
    // Throws ArithmeticException if b = 0
    public int divide(int a, int b) {
        return a / b;
    }

    // Checks whether a number is even
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Returns the larger of two numbers
    public int findMax(int a, int b) {
        return Math.max(a, b);
    }
}