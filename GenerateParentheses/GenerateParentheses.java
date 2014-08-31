// 递归解法
// reference: http://blog.csdn.net/fightforyourdream/article/details/14159435

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> rtn = new ArrayList<String>();
        rec(n, 0, 0, "", rtn);
        return rtn;
    }
    public static void rec(int n, int left, int right, String str, ArrayList<String> rtn) {
        if (left == n && right == n) {
            rtn.add(str);
            return;
        }
        if (left < right) {
            return;
        }
        if (left == n) {
            rec(n, left, right+1, str+")", rtn);
            return;
        }
        
        rec(n, left+1, right, str+"(", rtn);
        rec(n, left, right+1, str+")", rtn);
    }
}