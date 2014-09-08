public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] list = s.split(" ");
        String rtn = list[list.length - 1];
        return rtn.length();
    }
}