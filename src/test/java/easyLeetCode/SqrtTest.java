package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    @Test
    void mySqrt() {
        Sqrt sqrt = new Sqrt();
        int x1 = 121;
        int x2 = Integer.MAX_VALUE;
        int x3 = 0;
        int x4 = 1;

        assertEquals(11, sqrt.mySqrt(x1));
        assertEquals(46340, sqrt.mySqrt(x2));
        assertEquals(0, sqrt.mySqrt(x3));
        assertEquals(1, sqrt.mySqrt(x4));
    }
}