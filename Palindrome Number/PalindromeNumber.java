public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return reverse(x) == x ? true : false;
    }
    // the function from Reverse Integer problem
    public int reverse(int x) {
        int rtn = 0;
        if (x > Integer.MAX_VALUE) {
            return 0;
        }
        while (x != 0) {
            rtn = rtn * 10 + x % 10;
            x = x / 10;
        }
        return rtn;
    }
}