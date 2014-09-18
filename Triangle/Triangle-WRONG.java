public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int rtn = triangle.get(0).get(0);
        if (row == 1) {
            return rtn;
        }
        int prevIndex = 0;
        for (int i = 1; i < row; i++) {
            List<Integer> currRow = triangle.get(i);
            int min;
            if (currRow.get(prevIndex) > currRow.get(prevIndex+1)) {
                min = currRow.get(prevIndex+1);
                prevIndex++;
            } else {
                min = currRow.get(prevIndex);
            }
            rtn += min;
        }
        return rtn;
    }
}