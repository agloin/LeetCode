package easyLeetCode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();

    }
}
