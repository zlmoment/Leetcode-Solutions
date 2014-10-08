// binary search

public class Solution {
    public int sqrt(int x) {
        long left = 0, right = x / 2 + 1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)right;
    }
}