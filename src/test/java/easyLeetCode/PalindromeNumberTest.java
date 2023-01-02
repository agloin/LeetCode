package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    @Test
    void isPalindromeTrueTest() {
        int n = 121;
        int x = 1133223311;
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        assertTrue(palindromeNumber.isPalindrome(n));
        assertTrue(palindromeNumber.isPalindrome(x));
    }

    @Test
    void isPalindromeFalseTest() {
        int n = 123;
        int x = 1134343545;
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        assertFalse(palindromeNumber.isPalindrome(n));
        assertFalse(palindromeNumber.isPalindrome(x));
    }
}