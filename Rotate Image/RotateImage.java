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

        // following loop can NOT write as matrix = rtn;
        // "matrix" is just a reference to a 2-dimension array. 
        // If "matrix" is assigned to a new 2-dimension array 
        // in the method, the original array does not change. 
        // Therefore, there should be another loop to assign 
        // each element to the array referenced by "matrix". 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rtn[i][j];
            }
        }
    }
}