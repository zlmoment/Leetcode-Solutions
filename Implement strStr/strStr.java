public class Solution {
    public String strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) return null;
        if (needle.equals("")) return haystack;
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        boolean flag = true;
        for (int i = 0; i < haystackArr.length; i++) {
            if (haystackArr[i] == needleArr[0]) {
                flag = true;
                for (int j = 0; j < needleArr.length; j++) {
                    if (haystackArr[i+j] != needleArr[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) return haystack.substring(i);
            }
        }
        return null;
    }
}