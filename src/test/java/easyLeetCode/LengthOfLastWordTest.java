package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//https://leetcode.com/problems/length-of-last-word/

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        int length = s1.length;

        if (length > 0) return s1[length - 1].length();
        return 0;
    }
}
class LengthOfLastWordTest {

    @Test
    void lengthOfLastWord() {
        String s1 = "Hello World";
        String[] s11 = s1.split(" ");
        int length11 = s11.length;

        String s2 = "   fly me   to   the moon  ";
        String[] s21 = s2.split(" ");
        int length21 = s21.length;

        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals(s11[length11 - 1].length(), lengthOfLastWord.lengthOfLastWord(s1));
        assertEquals(s21[length21 - 1].length(), lengthOfLastWord.lengthOfLastWord(s2));
    }

    @Test
    void lengthOfLastWordWithEmptyString() {
        String s2 = " ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals(0, lengthOfLastWord.lengthOfLastWord(s2));
    }
}