package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

class IsValidPalindrome {
    public boolean isPalindrome(String s) {
        if (Objects.equals(s, " ")) return true;

        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                newS.append((char)(s.charAt(i) + 32));
            } else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                newS.append(s.charAt(i));
            }
        }

        if (newS.length() == 0) return true;

        int i = 0;
        int j = newS.length() - 1;

        while (i < j) {
            if (newS.charAt(i) != newS.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

public class IsValidPalindromeTest {

    @ParameterizedTest()
    @CsvSource(
            value = {
                    "'true','A man, a plan, a canal: Panama'",
                    "'false','race a car'",
                    "'true',' '",
                    "'false','0P'",
                    "'true',',.'",
                    "'true',',a.'",
                    "'true','000'",
                    "'true','lol'",
                    "'true','           lol      .,./()!@#$%'",
            }
    )
    public void test(boolean answer, String s) {
        IsValidPalindrome isPalindrome = new IsValidPalindrome();



        Assertions.assertEquals(answer, isPalindrome.isPalindrome(s));
    }
}
