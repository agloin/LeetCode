package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/roman-to-integer/
class RomanIntTest {

    @Test
    void romanToInt() {
        String s = "III";
        String s1 = "LVIII";
        String s2 = "MCMXCIV";
        RomanInt romanInt = new RomanInt();

        assertEquals(3, romanInt.romanToInt(s));
        assertEquals(58, romanInt.romanToInt(s1));
        assertEquals(1994, romanInt.romanToInt(s2));
    }
}