public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int occurs = 1;
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[index] == A[i]) {
                if (occurs == 2) {
                    continue;
                }
                occurs++;
            } else {
                occurs = 1;
            }
            index++;
            A[index] = A[i];
        }
        return index + 1;
    }
}