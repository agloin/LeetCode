package easyLeetCode;

class Factorial {
    // рекурсивный метод
    int fact(int n) {
        int result;

        if (n == 1)
            return 1;
        if (n < 13) {
            result = fact(n - 1) * n;
            return result;
        } else return -1;
    }
}
