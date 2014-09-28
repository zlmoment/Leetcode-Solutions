public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] d = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            d[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    int a = d[i-1][j-1] + 1; // 改x 改y
                    int b = d[i-1][j] + 1;   // 删x 插x
                    int c = d[i][j-1] + 1;   // 删y 插y
                    d[i][j] = Math.min(a, Math.min(b, c));
                }
            }
        }
        return d[m][n];
    }
}