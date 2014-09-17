public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int left, right, sum = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length; i++) {
            int first = num[i];
            left = i + 1;
            right = num.length - 1;
            while (left < right) {
                int newsum = first + num[left] + num[right];
                sum = (Math.abs(newsum - target) < Math.abs(sum - target)) ? newsum : sum ;
                if (newsum < target) {
                    left++;
                } else if (newsum > target) {
                    right--;
                } else {
                    return newsum;
                }
            }
        }
        return sum;
    }
}