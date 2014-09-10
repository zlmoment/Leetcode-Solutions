public class Solution {
    public int trap(int[] A) {
        int length = A.length;
        if (length <= 2) {
            return 0;
        }
        int[] left = new int[length];
        int[] right = new int[length];
        int rtn = 0;
        int max1 = A[0], max2 = A[length - 1];
        for (int i = 0; i < length; i++) {
            if (max1 < A[i]) {
                max1 = A[i];
            }
            if (max2 < A[length-i-1]) {
                max2 = A[length-i-1];
            }
            left[i] = max1;
            right[length-i-1] = max2;
        }
        for (int i = 0; i < length; i++) {
            int temp = Math.min(left[i], right[i]) - A[i];
            rtn += temp > 0 ? temp : 0;
        }
        return rtn;
    }
}