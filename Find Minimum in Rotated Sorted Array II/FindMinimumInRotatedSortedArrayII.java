/**
 * 如果全部的数字相等，我们就退化为O(N)，但是平均的复杂度仍然是O(LogN)，
 * 最后复杂度的大小取决于重复的数字的多少。如果重复字数少，与logN相差不大。
**/

public class Solution {
    public int findMin(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        int left = 0, right = num.length - 1;
        while (left <= right) {
            while (left + 1 < right && num[left] == num[left+1]) {
                left++;
            }
            while (right - 1 > left && num[right] == num[right-1]) {
                right--;
            }
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