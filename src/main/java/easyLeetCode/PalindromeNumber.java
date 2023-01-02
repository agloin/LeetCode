package easyLeetCode;


// Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String nums = Integer.toString(x);
        int i = 0;
        int j = nums.length() - 1;

        while (i <= j) {
            if (nums.charAt(i) != nums.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
