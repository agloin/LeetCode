package easyLeetCode;

//это не из Литкода


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Factorial {
    int fact(int n) {
        if (n==0) return 1;
        if (n >=13) return -1;
        else {
            int f = 1;
            for (int i = 2; i <= n; i++) f *= i;
            return f;
        }
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