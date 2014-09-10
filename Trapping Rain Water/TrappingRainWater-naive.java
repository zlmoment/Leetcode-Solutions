public class Solution {
    public int trap(int[] A) {
        int length = A.length;
        if (length <= 2) {
            return 0;
        }
        int[] left = new int[length];
        int[] right = new int[length];
        int rtn = 0;
        int max = A[0];
        for (int i = 0; i < length; i++) {
            if (max < A[i]) {
                max = A[i];
            }
            left[i] = max;
        }
        max = A[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            if (max < A[i]) {
                max = A[i];
            }
            right[i] = max;
        }
        for (int i = 0; i < length; i++) {
            int temp = Math.min(left[i], right[i]) - A[i];
            rtn += temp > 0 ? temp : 0;
        }
        return rtn;
    }
}