// refe: http://blog.csdn.net/abcbc/article/details/8982651

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rtn = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            rtn.add(0);
        }
        rtn.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            rtn.set(i, 1);
            for (int j = i - 1; j > 0; j--) {
                rtn.set(j, rtn.get(j) + rtn.get(j-1));
            }
        }
        return rtn;
    }
}