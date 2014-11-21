public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) return 0;
        int length = A.length;
        int insert = 0;
        for (int i = 0; i < A.length; i++) {
            while (i + 1 < A.length && A[i] == A[i+1]) {
                i++;
            }
            A[insert++] = A[i];
        }
        return insert;
    }
}