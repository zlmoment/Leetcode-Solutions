// very straight forward solution
// search for other solutions on the Internet

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rtn = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0) {
            return rtn;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int x = 0, y = 0;
        
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    rtn.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    rtn.add(matrix[x++][y]);
                }
                break;
            }
            for (int i = 0; i < n-1; i++) {
                rtn.add(matrix[x][y++]);
            }
            for (int i = 0; i < m-1; i++) {
                rtn.add(matrix[x++][y]);
            }
            for (int i = 0; i < n-1; i++) {
                rtn.add(matrix[x][y--]);
            }
            for (int i = 0; i < m-1; i++) {
                rtn.add(matrix[x--][y]);
            }
            x++;
            y++;
            m = m - 2;
            n = n - 2;
        }
        return rtn;
    }
}