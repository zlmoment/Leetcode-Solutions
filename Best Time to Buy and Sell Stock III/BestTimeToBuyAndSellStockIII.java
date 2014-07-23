public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int max = 0;
        int[] leftProfits = new int[prices.length];
        int[] rightProfits = new int[prices.length];
        /* from left to right */
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (minPrice < prices[i]) {
                max = (prices[i] - minPrice > max) ? prices[i] - minPrice : max;
            } else {
                minPrice = prices[i];
            }
            leftProfits[i] = max;
        }
        
        /* from right to left */
        max = 0;
        int maxPrice = prices[prices.length - 1];
        for (int j = prices.length - 1; j >= 0; j--) {
            if (maxPrice > prices[j]) {
                max = (max > maxPrice - prices[j]) ? max : maxPrice - prices[j];
            } else {
                maxPrice = prices[j];
            }
            rightProfits[j] = max;
        }
        
        max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = (max > leftProfits[i] + rightProfits[i]) ? max : leftProfits[i] + rightProfits[i];
        }
        return max;
    }
}