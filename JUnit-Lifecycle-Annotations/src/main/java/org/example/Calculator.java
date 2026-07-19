package org.example;

import org.example.Student;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int[] getNumbers() {
        return new int[]{1, 2, 3, 4, 5};
    }

    public String getNullName() {
        return null;
    }

    public String getCollegeName() {
        return "PCPS College";
    }

    public Student createStudent(String name, int age, String course) {
        return new Student(name, age, course);
    }
}