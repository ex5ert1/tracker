package ru.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    private Factorial factorial = new Factorial();

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, factorial.calc(0), "Факториал нуля должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, factorial.calc(5), "Факториал числа 5 должен быть равен 120");
        assertEquals(720, factorial.calc(6), "Факториал числа 6 должен быть равен 720");
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(3628800, factorial.calc(10), "Факториал числа 10 должен быть равен 3628800");
    }

    @Test
    public void testNegativeNumberThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calc(-1),
                "Должен быть выброшен IllegalArgumentException для отрицательных чисел");
    }
}