package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//это не из Литкода - это просто
class FactorialTest {

    @Test
    void factWithNumberOne() {
        Factorial factorial = new Factorial();

        assertEquals(1, factorial.fact(1));
    }

    @Test
    void factWithNumberOnFive() {
        Factorial factorial = new Factorial();

        assertEquals(120, factorial.fact(5));
    }

    @Test
    void factWithNumberOnMaxNumber() {
        Factorial factorial = new Factorial();

        assertEquals(479001600, factorial.fact(12));
    }

    @Test
    void factOverflow() {
        Factorial factorial = new Factorial();

        assertEquals(-1, factorial.fact(13));
    }
}