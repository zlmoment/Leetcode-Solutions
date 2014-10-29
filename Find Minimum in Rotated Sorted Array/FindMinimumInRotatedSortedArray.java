public class Solution {
    public int findMin(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        int left = 0, right = num.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num[left] < num[mid] && num[mid] > num[right]) {
                left = mid;
            } else if (num[left] > num[mid] && num[mid] < num[right]) {
                right = mid;
            } else {
                return Math.min(num[left], num[right]);
            }
        }
        return -1;
    }
}