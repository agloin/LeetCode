package easyLeetCode;

public class Sqrt {
    public int mySqrt(int x) {
        int i = 1;


        if (x == 1 || x == 2 || x == 3) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        int maxVal = Integer.MAX_VALUE;

        while (i < x && i * i <= maxVal && i * i > 0) {
            if (i * i > x) {
                return i - 1;
            }
            if (i * i == x) return i;
            i++;
        }
        return 46340;
    }
}
