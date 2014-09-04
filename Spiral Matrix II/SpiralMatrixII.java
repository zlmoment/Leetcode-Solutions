public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] rtn = new int[n][n];
        int x = 0, y = 0, num = 1, layer = n;
        while (layer > 0) {
            if (layer == 1) {
                rtn[n/2][n/2] = num;
                break;
            }
            for (int i = 0; i < layer-1; i++) {
                rtn[x][y++] = num++;
            }
            for (int i = 0; i < layer-1; i++) {
                rtn[x++][y] = num++;
            }
            for (int i = 0; i < layer-1; i++) {
                rtn[x][y--] = num++;
            }
            for (int i = 0; i < layer-1; i++) {
                rtn[x--][y] = num++;
            }
            x++;
            y++;
            layer -= 2;
        }
        return rtn;
    }
}