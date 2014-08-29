// 动态规划解法

// start[i]为 A[i..n-1]中包含A[i]的解，即为max(A[i], A[i] + start[i+1])
// sum[i]为 A[i..n-1]的解，即为max(start[i], sum[i+1])
// O(N)

public class Solution {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] sum = new int[n];
        int[] start = new int[n];
        sum[n-1] = A[n-1];
        start[n-1] = A[n-1];
        for (int i = n - 2; i >= 0; i--) {
            start[i] = max(A[i], A[i] + start[i+1]);
            sum[i] = max(start[i], sum[i+1]);
        }
        return sum[0];
    }
    
    public static int max(int x, int y) {
        return x > y ? x : y;
    }
}