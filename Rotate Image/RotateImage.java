// The most naive solution, not in place

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rtn = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rtn[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rtn[i][j];
            }
        }
    }
}