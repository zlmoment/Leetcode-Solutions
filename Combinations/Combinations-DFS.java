public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        
        buildResult(1, n, k, inList, rtn);
        return rtn;
    }
    
    // DFS
    public static void buildResult(int start, int n, int k, List<Integer> inList, List<List<Integer>> rtn) {
        if (inList.size() == k) {
            rtn.add(new ArrayList<Integer>(inList));
            return;
        }
        for (int i = start; i <= n; i++) {
            inList.add(i);
            buildResult(i+1, n, k, inList, rtn);
            inList.remove(inList.size() - 1);
        }
    }
}