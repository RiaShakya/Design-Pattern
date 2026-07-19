package org.example;

import org.example.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;



    @Test
    void testAdd() {
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 5);

        assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();

        int result = calculator.subtract(10, 5);

        assertEquals(5, result);
    }

    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();

        int result = calculator.multiply(4, 5);

        assertEquals(20, result);
    }

    @Test
    void testDivide() {
        Calculator calculator = new Calculator();

        int result = calculator.divide(20, 4);

        assertEquals(5, result);
    }

    @Test
    void testIsEvenForEvenNumber() {
        Calculator calculator = new Calculator();

        boolean result = calculator.isEven(8);

        assertTrue(result);
    }

    @Test
    void testIsEvenForOddNumber() {
        Calculator calculator = new Calculator();

        boolean result = calculator.isEven(7);

        assertFalse(result);
    }

    @Test
    void testAddNotEquals() {
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 5);

        assertNotEquals(20, result);
    }

    @Test
    void testDivideByZeroThrowsException() {
        Calculator calculator = new Calculator();

        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }

    @Test
    void testDivideDoesNotThrowException() {
        Calculator calculator = new Calculator();

        assertDoesNotThrow(
                () -> calculator.divide(10, 2)
        );
    }


    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Starting all calculator tests...");
    }

    @BeforeEach
    void setup() {
        calculator = new Calculator();
        System.out.println("Calculator created.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("All tests finished.");
    }

    @Test
    @DisplayName("Addition Test")
    void shouldAddTwoNumbers() {
        assertEquals(15,
                calculator.add(10, 5));
    }

    @Test
    @DisplayName("Addition Not Equal Test")
    void shouldNotReturnWrongAdditionResult() {
        assertNotEquals(20,
                calculator.add(10, 5));
    }

    @Test
    @DisplayName("Subtraction Test")
    void shouldSubtractTwoNumbers() {
        assertEquals(5,
                calculator.subtract(10, 5));
    }

    @Test
    @DisplayName("Even Number Test")
    void shouldReturnTrueForEvenNumber() {
        assertTrue(
                calculator.isEven(8)
        );
    }

    @Test
    @DisplayName("Odd Number Test")
    void shouldReturnFalseForOddNumber() {
        assertFalse(
                calculator.isEven(7)
        );
    }

    @Test
    @DisplayName("Null Test")
    void shouldReturnNullValue() {
        assertNull(
                calculator.getNullName()
        );
    }

    @Test
    @DisplayName("Not Null Test")
    void shouldReturnCollegeName() {
        assertNotNull(
                calculator.getCollegeName()
        );
    }

    @Test
    @DisplayName("Same Object Test")
    void shouldReferToSameObject() {

        Student s1 =
                new Student("Ram",20,"Java");

        Student s2 = s1;

        assertSame(s1, s2);
    }

    @Test
    @DisplayName("Different Object Test")
    void shouldReferToDifferentObjects() {

        Student s1 =
                new Student("Ram",20,"Java");

        Student s2 =
                new Student("Ram",20,"Java");

        assertNotSame(s1, s2);
    }

    @Test
    @DisplayName("Array Equals Test")
    void shouldReturnCorrectArray() {

        int[] expected = {1,2,3,4,5};

        assertArrayEquals(
                expected,
                calculator.getNumbers()
        );
    }

    @Test
    @DisplayName("Exception Test")
    void shouldThrowArithmeticException() {

        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10,0)
        );
    }

    @Test
    @DisplayName("No Exception Test")
    void shouldNotThrowException() {

        assertDoesNotThrow(
                () -> calculator.divide(10,2)
        );
    }

    @Test
    @DisplayName("Assert All Test")
    void shouldValidateStudentObject() {

        Student student =
                calculator.createStudent(
                        "Sita",
                        21,
                        "Software Engineering"
                );

        assertAll(
                () -> assertEquals("Sita",
                        student.getName()),

                () -> assertEquals(21,
                        student.getAge()),

                () -> assertEquals(
                        "Software Engineering",
                        student.getCourse())
        );
    }

    @RepeatedTest(3)
    @DisplayName("Repeated Multiplication Test")
    void shouldMultiplyNumbers() {

        assertEquals(
                20,
                calculator.multiply(4, 5)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    @DisplayName("Parameterized Even Test")
    void shouldReturnTrueForEvenNumbers(
            int number) {

        assertTrue(
                calculator.isEven(number)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7,9})
    @DisplayName("Parameterized Odd Test")
    void shouldReturnFalseForOddNumbers(
            int number) {

        assertFalse(
                calculator.isEven(number)
        );
    }
}