public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    int area = maxRec(matrix, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    // 给定一个点，算出这个点为左上角的最大矩形值
    public static int maxRec(char[][] matrix, int row, int col) {
        int minWidth = Integer.MAX_VALUE;
        int area = 0;
        for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {
            int currWidth = 0;
            while (col + currWidth < matrix[0].length && matrix[i][col + currWidth] == '1') {
                currWidth++;
            }
            minWidth = currWidth < minWidth ? currWidth : minWidth;
            int currArea = minWidth * (i - row + 1);
            area = currArea > area ? currArea : area;
        }
        return area;
    }
}