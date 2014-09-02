public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int a = height[i];
            for (int j = i+1; j < height.length; j++) {
                int b = height[j];
                int area = (j - i) * min(a, b);
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }
    
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}