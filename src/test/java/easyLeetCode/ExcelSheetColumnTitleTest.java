package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int n = columnNumber % 26;
            res.insert(0, (char) ('A' + n));
            columnNumber = columnNumber / 26;
        }
        return res.toString();
    }
}

public class ExcelSheetColumnTitleTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'ZY', 701",
                    "'ZX', 700",
                    "'B', 2",
                    "'AB', 28"
            }
    )
    public void test(String s, int columnNumber) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

        Assertions.assertEquals(s, excelSheetColumnTitle.convertToTitle(columnNumber));
    }
}
