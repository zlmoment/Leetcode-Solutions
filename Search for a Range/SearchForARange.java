// binary search

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] rtn = new int[]{-1, -1};
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                while (mid >= 0 && A[mid] == target) {
                    rtn[0] = mid;
                    mid--;
                }
                mid++;
                while (mid <= A.length-1 && A[mid] == target) {
                    rtn[1] = mid;
                    mid++;
                }
                break;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else if (A[mid] > target) {
                right = mid - 1;
            }
        }
        return rtn;
    }
}