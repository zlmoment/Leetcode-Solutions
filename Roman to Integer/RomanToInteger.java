/* 关于罗马数字计数法，看 http://baike.baidu.com/view/42061.htm?fr=aladdin */

public class Solution {
    public int romanToInt(String s) {
        if (s==null || s.length() == 0) return 0;
        char[] ch = s.toCharArray();
        int pre = 0, sum = 0;
        for (char c : ch) {
            if (c == 'I') { 
                sum += 1; pre = 1; 
            } else if (c == 'V') { 
                sum += 5;
                if (pre < 5)
                    sum -= 2 * pre;
                pre = 5;
            } else if (c == 'X') {
                sum += 10;
                if (pre < 10)
                    sum -= 2 * pre;
                pre = 10;
            } else if (c == 'L') {
                sum += 50;
                if (pre < 50)
                    sum -= 2 * pre;
                pre = 50;
            } else if (c == 'C') {
                sum += 100;
                if (pre < 100)
                    sum -= 2 * pre;
                pre = 100;
            } else if (c == 'D') {
                sum += 500;
                if (pre < 500)
                    sum -= 2 * pre;
                pre = 500;
            } else if (c == 'M') {
                sum += 1000;
                if (pre < 1000)
                    sum -= 2 * pre;
                pre = 1000;
            }
        }
        return sum;
    }
}