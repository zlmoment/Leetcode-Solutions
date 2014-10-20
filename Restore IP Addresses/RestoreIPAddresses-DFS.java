public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> rtn = new ArrayList<String>();
        if (len > 12 || len < 4) {
            return rtn;
        }
        dfs(rtn, "", 0, s);
        return rtn;
    }

    public static void dfs(List<String> rtn, String inList, int start, String s) {
        if (isValid(inList, s)) {
            rtn.add(new String(inList.substring(0, inList.length() - 1)));
            return;
        }
        //System.out.println(inList);
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }
            inList = inList + s.substring(start, start + i) + ".";
            dfs(rtn, inList, start + i, s);
            inList = inList.substring(0, inList.length() - i - 1);
        }
    }

    public static boolean isValid(String ip, String s) {
        if (ip.equals("")) {
            return false;
        }
        ip = ip.substring(0, ip.length() - 1);
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return false;
        }
        int length = 0;
        for (int i = 0; i < 4; i++) {
            if (ipArr[i].length() > 1 && ipArr[i].charAt(0) == '0') {
                return false;
            }
            int temp = Integer.valueOf(ipArr[i]);
            if (temp > 255) {
                return false;
            }
            length += ipArr[i].length();
        }
        if (length == s.length()) {
            return true;
        }
        return false;
    }
}