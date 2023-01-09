package easyLeetCode;

import org.junit.jupiter.api.Test;

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
    @Test
    void lengthOfLastWord() {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals("World".length(), lengthOfLastWord.lengthOfLastWord("Hello World"));
        assertEquals("moon".length(), lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    }

    @Test
    void lengthOfLastWordWithEmptyString() {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals("".length(), lengthOfLastWord.lengthOfLastWord(" "));
    }

    @Test
    void lengthOfLastWordWithOneSymbolAndSpaceInEnd() {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals("a".length(), lengthOfLastWord.lengthOfLastWord("a "));
        assertEquals("a".length(), lengthOfLastWord.lengthOfLastWord("a"));
    }


}