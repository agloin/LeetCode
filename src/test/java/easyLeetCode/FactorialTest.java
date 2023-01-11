package easyLeetCode;

//это не из Литкода


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Factorial {
    int fact(int n) {
        if (n == 0) return 1;
        if (n >= 13) return -1;
        else {
            int f = 1;
            for (int i = 2; i <= n; i++) f *= i;
            return f;
        }
    }
}


class FactorialTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1, 1",
                    "5, 120",
                    "6, 720",
                    "12, 479001600"

            }
    )
    void factWithNumberOne(int n, int answer) {
        Factorial factorial = new Factorial();

        assertEquals(answer, factorial.fact(n));
    }
}