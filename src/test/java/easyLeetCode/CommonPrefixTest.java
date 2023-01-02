package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/longest-common-prefix/
class CommonPrefixTest {

    @Test
    void longestCommonPrefixWithCommonSymbolsTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"flower","flow","flight"};
        String answer = "fl";

        assertEquals(answer, commonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void longestCommonPrefixWithoutCommonSymbolsTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"dog","racecar","car"};

        assertEquals("", commonPrefix.longestCommonPrefix(strs));
    }
}