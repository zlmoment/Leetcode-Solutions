public class Solution {
    public int search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }
}