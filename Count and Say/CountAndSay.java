public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = 1; i < n; i++) {
            count = 1;
            sb.setLength(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j-1)) {
                    count++;
                } else {
                    sb.append(count).append(s.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count).append(s.charAt(s.length() - 1));
            s = sb.toString();
        }
        return sb.toString();
    }
}