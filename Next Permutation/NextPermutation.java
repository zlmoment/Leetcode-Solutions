// the algorithm: http://www.lifeincode.net/programming/leetcode-next-permutation-java/

public class Solution {
    public void nextPermutation(int[] num) {
        for (int i = num.length-1; i > 0; i--) {
            if (num[i-1] < num[i]) {
                int leftNum = num[i-1], rightNum = 0, rightIndex = 0;
                for (int j = num.length-1; j > i - 1 ; j--) {
                    if (num[j] > leftNum) {
                        rightIndex = j;
                        rightNum = num[j];
                        break;
                    }
                }
                // swap
                num[i-1] = rightNum;
                num[rightIndex] = leftNum;
                // reverse
                int left = i;
                int right = num.length-1;
                while (left < right) {
                    int temp = num[left];
                    num[left] = num[right];
                    num[right] = temp;
                    left++;
                    right--;
                }
                return;
            }
        }
        int left = 0;
        int right = num.length-1;
        while (left < right) {
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
}