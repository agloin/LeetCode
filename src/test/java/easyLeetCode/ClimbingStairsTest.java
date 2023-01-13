package easyLeetCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/climbing-stairs/

class ClimbingStairs {
    public int climbStairs(int n) {
        int tmp1 = 1;
        int tmp2 = 1;
        int next = 0;

        if (n == 1 || n == 0) return 1;

        for (int i = 2; i <= n; i++) {
            next = tmp1 + tmp2;
            tmp1 = tmp2;
            tmp2 = next;
        }
        return next;
    }
}

class ClimbingStairsTest {


    @ParameterizedTest()
    @CsvSource(
            value = {
                    "0, 1",
                    "1, 1",
                    "5, 8",
                    "45, 1836311903"
            }
    )
    void climbingStairsTest(int n, int answer) {
        ClimbingStairs climbingStairs = new ClimbingStairs();


        assertEquals(answer, climbingStairs.climbStairs(n));

    }

}