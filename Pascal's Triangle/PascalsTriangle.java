public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        List<Integer> preInList = new ArrayList<Integer>();
        preInList.add(1);
        if (numRows == 0) 
            return rtn;
        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    inList.add(preInList.get(0));
                } else if (j == i - 1) {
                    inList.add(preInList.get(j - 1));
                } else {
                    inList.add(preInList.get(j - 1) + preInList.get(j));
                }
            }
            preInList.clear();
            preInList.addAll(inList);
            rtn.add(inList);
            inList = new ArrayList<Integer>();
        }
        return rtn;
    }
}