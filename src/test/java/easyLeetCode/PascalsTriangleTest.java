package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/description/
class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    Integer sumPre = tmp.get(j) + tmp.get(j - 1);
                    row.add(j, sumPre);
                }
            }
            tmp = row;
            res.add(i, row);
        }
        return res;
    }
}

public class PascalsTriangleTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]', 5",
                    "'[1]', 1"
            }
    )
    void PascalsTriangleGenerateTest(String compare, int numRows) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> compareAnswer;

        compareAnswer = fill(compare);

        var res = pascalsTriangle.generate(numRows);

        Assertions.assertEquals(compareAnswer, res);

    }


    // ВСЕ, ЧТО НИЖЕ НАПИСАЛ CHAT-GPT
    public List<List<Integer>> fill(String input) {

        List<List<Integer>> result = new ArrayList<>();
        input = input.substring(1, input.length() - 1);
        String[] rows = input.split("\\],\\[");

        for (String row : rows) {
            List<Integer> numbers = new ArrayList<>();
            String[] elements = row.split(",");
            for (String element : elements) {
                if (isNumeric(element)) {
                    numbers.add(Integer.parseInt(element));
                }
            }
            result.add(numbers);
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

