package easyLeetCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/longest-common-prefix/

class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int strsLength = strs.length;

        if (strsLength == 1) {
            return strs[0];
        }
        int numStr = 1;

        for (int i = 0; i < strsLength - 1; i++) {
            if (strs[i].length() == 0 || strs[i + 1].length() == 0) {
                return "";
            }
            if (strs[i].length() < strs[i + 1].length() && strs[i].length() < strs[numStr].length()) { numStr = i; }
            else if (strs[numStr].length() > strs[i + 1].length()) {
                numStr = i + 1;
            }
        }

        int k = 0;
        int index = 10000;
        for (int i = 0; i < strsLength; i++) {
            if (i != numStr) {
                while (k < strs[numStr].length() && strs[numStr].charAt(k) == strs[i].charAt(k)) {
                    k++;
                }
                if (k == 0) return "";
                if (k < index)
                    index = k;
            }
            k = 0;
        }
        return strs[numStr].substring(0, index);
    }
}


class CommonPrefixTest {

    @Test
    void longestCommonPrefixWithCommonPrefixTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};

        assertEquals("fl", commonPrefix.longestCommonPrefix(strs));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "c, acc, ccc",
            "a, a, b",
            "reflower, flow, flight",
            "abab, aba, ''"
    }

    )
    void longestCommonPrefixWithOneWordWithoutCommonPrefixTest(String str1, String str2, String str3) {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{str1, str2, str3};

        assertEquals("", commonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void longestCommonPrefixWithOneEmptyElementTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"flower"};

        assertEquals("flower", commonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void longestCommonPrefixWithoutCommonPrefixTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"dog", "racecar", "car"};

        assertEquals("", commonPrefix.longestCommonPrefix(strs));
    }
}