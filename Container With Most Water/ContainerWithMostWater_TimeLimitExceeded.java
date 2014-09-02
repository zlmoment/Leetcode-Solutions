public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int a = height[i];
            for (int j = i+1; j < height.length; j++) {
                int b = height[j];
                int area = Math.abs(a-b) * max(a, b);
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }
    
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}