package easyLeetCode;

import java.util.ArrayList;
import java.util.Stack;

// "(({}))"
// ({){}[}](({}))
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.add(')');
            else if (c == '{') stack.add('}');
            else if (c == '[') stack.add(']');

            else if (stack.isEmpty() || stack.pop() != c) return false;

            System.out.println("stack " + stack);
        }
        return stack.isEmpty();
    }
}

