public class Solution {
    public String reverseWords(String s) {
        if (s == null)
            return null;
        s = s.trim();
        String[] strArray = s.split(" ");
        // Use StringBuffer to improve the performance
        StringBuffer sb = new StringBuffer();
        for (int i = strArray.length - 1; i >= 0; i--) {
            if (!strArray[i].trim().equals("")) {
                sb.append(strArray[i].trim() + " ");
            }
        }
        return sb.toString().trim();
    }
}