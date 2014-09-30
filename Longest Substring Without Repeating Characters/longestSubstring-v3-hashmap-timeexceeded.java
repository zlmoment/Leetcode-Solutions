/**
 * @author: Zhaoyu Li
 * 
 * This is NOT a right solution, time exceeded!!!
 *
**/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // This is NOT a right solution, time exceeded!!!
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int counter = 0;
        int max = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!hm.containsKey(charArray[i])) {
                hm.put(charArray[i], i);
                counter++;
            } else {
                max = (max > counter) ? max : counter;
                int index = hm.get(charArray[i]);
                for (int j = 0; j <= index; j++)
                    hm.remove(charArray[j]);
                hm.put(charArray[i], i);
                counter = hm.size();
            }
        }
        max = (max > counter) ? max : counter;
        return max;
    }
}