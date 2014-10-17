// brute force: time limitation exceeded

public class Solution {
    public String longestPalindrome(String s) {
        String rtn = "";
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                String sub = s.substring(i,j);
                if (sub.length() > longest) {
                    if (isPalin(sub)) {
                        rtn = sub;
                        longest = sub.length();
                    }
                }
            }
        }
        return rtn;
    }
    
    public boolean isPalin(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}