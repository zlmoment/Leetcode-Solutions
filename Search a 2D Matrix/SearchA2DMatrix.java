// Note: binary search
// key: treat the whole matrix as an array

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0, end = m * n - 1;
        
        while (start <= end) {  // notice the '<='
            int mid = (start + end) / 2;
            int midX = mid / n; // line
            int midY = mid % n; // column
            if (target == matrix[midX][midY]) {
                return true;
            }
            if (target < matrix[midX][midY]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}