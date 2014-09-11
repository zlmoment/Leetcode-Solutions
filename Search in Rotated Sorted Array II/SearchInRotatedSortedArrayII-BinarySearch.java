// binary search
// reference: http://blog.csdn.net/linhuanmars/article/details/20588511

public class Solution {
    public boolean search(int[] A, int target) {
        int len = A.length;
        int left = 0, right = len - 1;
        int rtn;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == A[mid]) {
                return true;
            }
            if (A[mid] > A[left]) { // left is sorted
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (A[mid] < A[left]) {
                if (A[mid] < target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}