public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) return digits;
        if (digits[len - 1] != 9) {
            digits[len - 1] += 1;
            return digits;
        } else {
            while (digits[len - 1] == 9 && len > 0) {
                digits[len - 1] = 0;
                if (len == 1) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    return newDigits;
                }
                len--;
            }
            digits[len - 1] += 1;
        }
        return digits;
    }
}