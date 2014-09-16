public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String rtn = "";
        if (strs.length == 0) {
            return rtn;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        rtn = strs[0];
        for (int i = 0; i < rtn.length(); i++) {
            char c = rtn.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return rtn.substring(0, i);
                }
            }
        }
        
        return rtn;
    }
}