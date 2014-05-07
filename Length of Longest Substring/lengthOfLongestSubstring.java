/**
 * @author: Zhaoyu Li
 * 
 * see http://goo.gl/w4zYMz for details.
 * 
**/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int i = 0, j = 0, max = 0;
        int[] exist = new int[256];
        if (length == 0) {
            return 0;
        }
        while (j < length) {
            if (exist[s.charAt(j)] == 1) {
                if (j - i > max) {
                    max = j - i;
                }
                while (s.charAt(i) != s.charAt(j)) {
                    exist[s.charAt(i)] = 0;
                    i++;
                }
                i++;
                j++;
            }
            else {
                exist[s.charAt(j)] = 1;
                j++;
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