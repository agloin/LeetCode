package easyLeetCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


//https://leetcode.com/problems/length-of-last-word/

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        while (i>= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int endOfLastWord = i;

        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return endOfLastWord - i;
    }
}

class LengthOfLastWordTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "Hello World, World",
                    "'   fly me   to   the moon  ', 'moon'",
                    "'a ', 'a'",
                    "'         ', ''"
            }
    )
    void lengthOfLastWord(String s, String answer) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();


        assertEquals(answer.length(), lengthOfLastWord.lengthOfLastWord(s));
    }

}