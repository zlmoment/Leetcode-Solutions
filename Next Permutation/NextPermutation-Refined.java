// the algorithm: http://www.lifeincode.net/programming/leetcode-next-permutation-java/

public class Solution {
    public void nextPermutation(int[] num) {
        int left = 0, right = 0;
        for (left = num.length - 2; left >= 0; left--) {
            if (num[left] < num[left + 1]) {
                for (right = num.length - 1; right > left ; right--) {
                    if (num[right] > num[left]) {
                        break;
                    }
                }
                break;
            }
        }
        // swap
        int temp;
        if (left >= 0) {
            temp = num[left];
            num[left] = num[right];
            num[right] = temp;
        }
        // reverse
        int l = left + 1, r = num.length - 1;
        while (l < r) {
            temp = num[l];
            num[l++] = num[r];
            num[r--] = temp;
        }
    }
}