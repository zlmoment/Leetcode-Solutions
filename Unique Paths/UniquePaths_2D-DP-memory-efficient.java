// 二维动态规划解法 - 观察上个解法的状态转移方程，可以省内存

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] d = new int[n];
        d[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                d[j] = d[j] + d[j-1];
            }
        }
        return d[n-1];
    }
}