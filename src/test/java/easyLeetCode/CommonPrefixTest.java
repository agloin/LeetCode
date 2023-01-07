package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/longest-common-prefix/

//"flower" "flow" "flight"
class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int j = 0;
        int k = 1;
        StringBuilder answer = new StringBuilder(strs[0]);

        if (strs.length == 1) {
            return strs[0];
        }
        while (k < strs.length) {
            while (j < answer.length() && j < strs[k].length() && answer.charAt(j) == strs[k].charAt(j)) {
                j++;
            }
            answer = new StringBuilder(strs[0].substring(0, j));
            if (j == 0) {
                return "";
            }
            j = 0;
            k++;
        }
        return answer.toString();
    }
}


class CommonPrefixTest {

    @Test
    void longestCommonPrefixWithCommonPrefixTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"flower","flow","flight"};
        String answer = "fl";

        assertEquals(answer, commonPrefix.longestCommonPrefix(strs));
    }
    @Test
    void longestCommonPrefixWithOneWordWithoutCommonPrefixTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"flower","flow","withoutCommonPrefix"};
        String answer = "fl";

        assertEquals(answer, commonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void longestCommonPrefixWithOneEmptyElementTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"flower"};
        String answer = strs[0];

        assertEquals(answer, commonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void longestCommonPrefixWithoutCommonPrefixTest() {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = new String[]{"dog","racecar","car"};

        assertEquals("", commonPrefix.longestCommonPrefix(strs));
    }
}