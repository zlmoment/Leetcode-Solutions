// DP
// reference: http://goo.gl/VfnGPq

public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        if (n > m) {
            return 0;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (T.charAt(i-1) != S.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }
}