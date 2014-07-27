/*
 * 从后往前merge，两两比较A和B中元素，大的放后面
 */

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        while (m !=0 && n != 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        if (n != 0) {
            for (int i = 0; i < n; i++)
                A[i] = B[i];
        }
    }
}