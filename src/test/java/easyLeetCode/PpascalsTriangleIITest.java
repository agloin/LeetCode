package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = null;

        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    assert tmp != null;
                    Integer sumPre = tmp.get(j) + tmp.get(j - 1);
                    row.add(j, sumPre);
                }
            }
            tmp = row;
            res.add(i, row);
        }

        return res.get(rowIndex);
    }
}

public class PpascalsTriangleIITest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'[1,4,6,4,1]', 4",
                    "'[1]', 0",
                    "'[1,5,10,10,5,1]', 5"
            }
    )
    void PascalsTriangleGenerateTest(String compare, int rowIndex) {
        PascalsTriangleII pascalsTriangle = new PascalsTriangleII();
        List<Integer> compareAnswer = fill(compare);

        List<Integer> res = pascalsTriangle.getRow(rowIndex);

        Assertions.assertEquals(compareAnswer, res);

    }


    // ВСЕ, ЧТО НИЖЕ НАПИСАЛ CHAT-GPT
    public List<Integer> fill(String inputString) {
        inputString = inputString.substring(1, inputString.length() - 1);
        String[] rows = inputString.split("\\],\\[");
        List<Integer> numbers = new ArrayList<>();

        for (String row : rows) {
            String[] elements = row.split(",");

            for (String element : elements) {
                if (isNumeric(element)) {
                    numbers.add(Integer.parseInt(element));
                }
            }
        }
        return numbers;
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
