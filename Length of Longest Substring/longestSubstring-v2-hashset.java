/**
 * @author: Zhaoyu Li
 * 
**/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h = new HashSet<Character>();
        int left = 0;
        int max = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!h.contains(charArray[i])) {
                h.add(charArray[i]);
            } else {
                if (i - left > max) {
                    max = i - left;
                }
                while (charArray[left] != charArray[i]) {
                    h.remove(charArray[left++]);
                }
                left++;
            }
        }
        /* if the longest substring is at the end of s */
        return (max - charArray.length + left > 0) ? max : charArray.length - left;
    }
}