public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rtn = new ArrayList<List<String>>();
        List<String> inList = new ArrayList<String>();
        dfs(s, rtn, inList);
        return rtn;
    }
    public void dfs(String s, List<List<String>> rtn, List<String> inList) {
        if (s.length() == 0) {
            rtn.add(new ArrayList<String>(inList));
        }
        for (int i = 1; i <= s.length(); i++) {
            String leftPart = s.substring(0, i);
            if (isPalindrome(leftPart)) {
                inList.add(leftPart);
                dfs(s.substring(i), rtn, inList);
                inList.remove(inList.size()-1);
            }
        }
    }
    public boolean isPalindrome (String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}