/**
 * @author: Zhaoyu Li
 * 
 * see http://goo.gl/w4zYMz for details.
 * 
**/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int i = 0, max = 0;
        int[] exist = new int[256];
        if (length == 0) {
            return 0;
        }
        for (int idx = 0 ; idx < length; idx++) {
            if (exist[s.charAt(idx)] == 1) {
                if (idx - i > max) {
                    max = idx - i;
                }
                while (s.charAt(i) != s.charAt(idx)) {
                    exist[s.charAt(i)] = 0;
                    i++;
                }
                i++;
            }
            else {
                exist[s.charAt(idx)] = 1;
            }
        }
        if (length - i > max) {
            return length - i;
        }
        else {
            return max;
        }
    }
}