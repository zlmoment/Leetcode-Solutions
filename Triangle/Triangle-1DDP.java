// 1D DP : http://goo.gl/c2kuJo

// bottom up solution

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] d = new int[row][row];
        for (int i = 0; i < row; i++) {
            d[row-1][i] = triangle.get(row-1).get(i);
        }
        for (int i = row - 2; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                d[i][j] = Math.min(d[i+1][j], d[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return d[0][0];
    }
}