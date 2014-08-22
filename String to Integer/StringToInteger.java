public class Solution {
    public static int atoi(String str) {
		if (str == null || str.trim().equals("")) {
			return 0;
		}
		str = str.trim();
		char[] strArr = str.toCharArray();
		int rtn = 0;
		int flag = 1;
		int step = 0;
		if (strArr[step] == '-') {
			step++;
			flag = -1;
		} else if (strArr[step] == '+') {
			step++;
		} else if (Character.isDigit(strArr[step])) {
			rtn = rtn * 10 + (strArr[step] - '0') * flag;
			step++;
		} else {
			return 0;
		}
		while (step < strArr.length && Character.isDigit(strArr[step])) {
			if (rtn != 0 && flag == 1 && rtn > (Integer.MAX_VALUE - (strArr[step] - '0')) / 10) {
				return Integer.MAX_VALUE;
			} else if (rtn != 0 && flag == -1 && rtn < (Integer.MIN_VALUE + (strArr[step] - '0')) / 10) {
			    return Integer.MIN_VALUE;
			}
			rtn = rtn * 10 + (strArr[step] - '0') * flag;
			step++;
		}
		return rtn;
	}
}