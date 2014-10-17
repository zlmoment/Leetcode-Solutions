// Time Limitation Exceeded

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) {
            return false;
        }
        return rec(s, dict, 0);
    }
    
    public static boolean rec(String s, Set<String> dict, int start) {
        if (start > s.length()) {
            return false;
        }
        if (start == s.length()) {
            return true;
        }
        for (String item : dict) {
            int lenOfItem = item.length();
            if (start + lenOfItem >= s.length()) {
                continue;
            }
            if (s.substring(start, start + lenOfItem).equals(item)) {
                if (rec(s, dict, start + lenOfItem)) {
                    return true;
                }
            }
        }
        return false;
    }
}