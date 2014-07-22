public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null) return 0;
        int duplen = 0;
        int insert = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                duplen++;
            } else {
                A[insert++] = A[i];
            }
        }
        return A.length - duplen;
    }
}