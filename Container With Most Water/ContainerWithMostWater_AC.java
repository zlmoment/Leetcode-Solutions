// O(N)
// 两个指针向中间靠拢

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int lHeight = height[left], rHeight = height[right];
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * min(lHeight, rHeight);
            maxArea = area > maxArea ? area : maxArea;
            if (lHeight > rHeight) {
                while (height[right] <= rHeight && left < right) {
                    right--;
                }
                rHeight = height[right];
            } else {
                while (height[left] <= lHeight && left < right) {
                    left++;
                }
                lHeight = height[left];
            }
        }
        return maxArea;
    }
    
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}