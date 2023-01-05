package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void climbingStairsTest() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int n0 = 0;
        int n1 = 1;
        int n5 = 5;
        int nMax = 45;

        assertEquals(1, climbingStairs.climbStairs(n0));
        assertEquals(1, climbingStairs.climbStairs(n1));
        assertEquals(8, climbingStairs.climbStairs(n5));
        assertEquals(1836311903, climbingStairs.climbStairs(nMax));
    }

}