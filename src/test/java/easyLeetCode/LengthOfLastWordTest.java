package easyLeetCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


//https://leetcode.com/problems/length-of-last-word/

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int res = 0;

        if (i == 0 && s.charAt(i) != ' ' && s.charAt(i) != '\t') return 1;
        else if (i == 0 && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) return 0;

        while (s.charAt(i) == ' ' || s.charAt(i) == '\t') {
            i--;
        }
        while (i >= 0 && (s.charAt(i) != ' ' || s.charAt(i) == '\t')) {
            res++;
            i--;
        }
        return res;
    }
}

class LengthOfLastWordTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Hello World",
                    "   fly me   to   the moon  "
            }
    )
    void lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals(s1[s1.length - 1].length(), lengthOfLastWord.lengthOfLastWord(s));
    }

    @Test
    void lengthOfLastWordWithEmptyString() {
        String s2 = " ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals(0, lengthOfLastWord.lengthOfLastWord(s2));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "a",
                    "a "
            }
    )
    void lengthOfLastWordWithOneSymbolAndSpaceInEnd(String s) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals(1, lengthOfLastWord.lengthOfLastWord(s));
    }


}