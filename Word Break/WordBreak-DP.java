// dp
// dp[i] means s.substring(0,i) is true
// dp[i] = true  sub(0,i) in dict
//       else = true if dp[k] && sub(k,i) in dict for k from 0 to i-1
//       else = false

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        if (length == 0) {
            return false;
        }
        boolean[] dp = new boolean[length+1];
        for (int i = 1; i <= length; i++) {
            String sub = s.substring(0,i);
            if (dict.contains(sub)) {
                dp[i] = true;
            } else {
                for (int k = 0; k < i; k++) {
                    if (dp[k] && dict.contains(s.substring(k,i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[length];
    }
}