public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length; 
        if (target < matrix[0][0]) {
            return false;
        }
        int start = 0, end = row-1;
        while (start <= end) {  
             int mid = (start + end) / 2;  
             if (matrix[mid][0] == target) {
                  return true;
             } else if (matrix[mid][0] < target) {
                  start = mid + 1;
             } else {
                  end = mid - 1;
             }
        }  
        int targetRow = end;  
        start = 0;  
        end = col-1;  
        while (start <= end) {  
             int mid = (start + end) / 2;  
             if (matrix[targetRow][mid] == target) {
                  return true;
             } else if (matrix[targetRow][mid] < target) {
                  start = mid + 1;
             } else {
                  end = mid - 1;
             }
        }  
        return false;  
    }
}