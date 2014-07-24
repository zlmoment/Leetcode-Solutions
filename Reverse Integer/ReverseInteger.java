public class Solution {
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;
        int rtn = 0;
        while (x != 0) {
            rtn = rtn * 10 + x % 10;
            x = x / 10;
        }
        return rtn;
    }
}