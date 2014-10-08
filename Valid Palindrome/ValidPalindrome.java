public class Solution {
    public boolean isPalindrome(String s) {
        if (s.trim().length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i);
            if (temp >= 97 && temp <= 122 || temp >= 48 && temp <= 57) {
                sb.append((char)temp);
            }
        }
        String original = sb.toString();
        int left = 0, right = original.length() - 1;
        while (left <= right) {
            if (original.charAt(left) == original.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}