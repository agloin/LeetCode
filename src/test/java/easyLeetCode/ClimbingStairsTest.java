package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/climbing-stairs/
class ClimbingStairsTest {

    @Test
    void ClimbingStairsTest() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int n1 = 1;
        int n5 = 5;
        int nMax = 45;

        assertEquals(1, climbingStairs.climbStairs(n1));
        assertEquals(8, climbingStairs.climbStairs(n5));
        assertEquals(1836311903, climbingStairs.climbStairs(nMax));
    }

}