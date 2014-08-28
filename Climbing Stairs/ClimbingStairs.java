// 非常典型的一维动态规划问题，也可以递归求解

public class Solution {
    public int climbStairs(int n) {
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }
}