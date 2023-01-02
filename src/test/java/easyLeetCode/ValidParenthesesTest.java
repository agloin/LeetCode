package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//https://leetcode.com/problems/valid-parentheses/
class ValidParenthesesTest {

    @Test
    void isValidTrue() {
        String valid1 = "(()[]{})";
        String valid2 = "()";
        ValidParentheses validParentheses = new ValidParentheses();


        assertTrue(validParentheses.isValid(valid1));
        assertTrue(validParentheses.isValid(valid2));
    }

    @Test
    void isValidFalse() {
        String invalid1 = "}{";
        String invalid2 = "(]()()()()()()()";
        ValidParentheses validParentheses = new ValidParentheses();


        assertFalse(validParentheses.isValid(invalid1));
        assertFalse(validParentheses.isValid(invalid2));
    }
}