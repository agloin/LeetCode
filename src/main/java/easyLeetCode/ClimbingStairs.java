package easyLeetCode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // if (n == 1) return 1;

        // int res = 0;

        // res = climbStairs(n - 1) + climbStairs(n - 2);
        // return res;

        int tmp1 = 1;
        int tmp2 = 1;
        int next = 0;

        if (n == 1) return 1;

        for (int i = 2; i <= n; i++) {
            next = tmp1 + tmp2;
            tmp1 = tmp2;
            tmp2 = next;
        }
        return next;
    }
}
