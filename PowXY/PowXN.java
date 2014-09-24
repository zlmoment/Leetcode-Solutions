public class Solution {
    public double pow(double x, int n) {
        if (x == 1.0) {
            return 1.0;
        }
        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }
        if (n == 0) {
            return 1.0;
        }
        double rtn = 1;
        int num = n < 0 ? -n : n;
        for (int i = 0; i < num; i++) {
            rtn *= x;
            if (rtn < 0.00000001 && rtn > 0) {
                return 0;
            }
        }
        return n < 0 ? 1/rtn : rtn;
    }
}