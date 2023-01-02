package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//https://leetcode.com/problems/length-of-last-word/
class LengthOfLastWordTest {

    @Test
    void lengthOfLastWord() {
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        assertEquals(5, lengthOfLastWord.lengthOfLastWord(s1));
        assertEquals(4, lengthOfLastWord.lengthOfLastWord(s2));
    }
}