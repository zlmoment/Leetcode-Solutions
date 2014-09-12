public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] d = new int[n];
        d[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    d[j] = 0;
                } else if (j > 0) {
                    d[j] = d[j] + d[j-1];
                }
            }
        }
        return d[n-1];
    }
}