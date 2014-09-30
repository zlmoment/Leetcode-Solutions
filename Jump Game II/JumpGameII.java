public class Solution {
    public int jump(int[] A) {
        int rtn = 0, canArrive = 0, lastCanArrive = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > lastCanArrive) {
                rtn++;
                lastCanArrive = canArrive;
            }
            canArrive = i + A[i] > canArrive ? i + A[i] : canArrive;
        }
        return rtn;
    }
}