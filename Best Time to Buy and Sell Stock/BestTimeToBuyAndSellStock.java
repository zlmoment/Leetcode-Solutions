public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (min < prices[i]) {
                max = (prices[i] - min > max) ? prices[i] - min : max;
            } else {
                min = prices[i];
            }
        }
        return max;
    }
}

/* Notes 
 * We can not use double nested for loop, time will exceeded;
 * Buying can only happen before selling.
 */