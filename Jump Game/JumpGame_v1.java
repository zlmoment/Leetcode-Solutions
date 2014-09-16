// reference: http://www.cnblogs.com/TenosDoIt/p/3719630.html

public class Solution {
    public boolean canJump(int[] A) {
        int canArrive = 0;
        int n = A.length;
        for (int i = 0; i <= canArrive && canArrive < n-1; i++) {
            if (i + A[i] > canArrive) {
                canArrive = i + A[i];
            }
        }
        return canArrive >= n-1;
    }
}