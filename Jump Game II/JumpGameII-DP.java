public class Solution {
    // this DP solution is TLE
    public int jump_TLE_dp(int[] A) {
        int n = A.length;
        int[] d = new int[n];
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    if (d[j] + 1 < d[i]) {
                        d[i] = d[j] + 1;
                    }
                }
            }
        }
        return d[n-1];
    }
    
    // this DP solution is also TLE
    public int jump_TLE_dp2(int[] A) {
        int n = A.length;
        int[] d = new int[n];
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            int furthest = Math.min(i + A[i], n - 1);
            for (int j = i + 1; j <= furthest; j++) {
                if (d[j] > d[i] + 1) {
                    d[j] = d[i] + 1;
                }
            }
        }
        return d[n-1];
    }
}