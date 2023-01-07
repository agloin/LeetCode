package easyLeetCode;

//это не из Литкода


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Factorial {
    // рекурсивный метод
    int fact(int n) {
        int result;

        if (n == 1)
            return 1;
        if (n < 13) {
            result = fact(n - 1) * n;
            return result;
        } else return -1;
    }
}


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