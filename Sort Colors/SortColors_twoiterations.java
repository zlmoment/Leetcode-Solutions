// The most naive solution

public class Solution {
    public void sortColors(int[] A) {
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                num0++;
            } else if (A[i] == 1) {
                num1++;
            } else {
                num2++;
            }
        }
        for (int i = 0; i < num0; i++) {
            A[i] = 0;
        }
        for (int i = num0; i < num0 + num1; i++) {
            A[i] = 1;
        }
        for (int i = num0 + num1; i < num0 + num1 + num2; i++) {
            A[i] = 2;
        }
    }
}