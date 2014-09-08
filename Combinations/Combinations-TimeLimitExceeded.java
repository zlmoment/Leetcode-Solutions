// wrong solution: see line 23, start+1 should be i+1


public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        
        int start = 1, num = 0;
        List<Integer> inList = new ArrayList<Integer>();
        buildResult(start, num, n, k, inList, rtn);
        return rtn;
    }
    
    // DFS
    public static void buildResult(int start, int num, int n, int k, List<Integer> inList, List<List<Integer>> rtn) {
        if (num == k) {
            List<Integer> temp = new ArrayList<Integer>(inList);
            rtn.add(temp);
            return;
        }
        for (int i = start; i <= n; i++) {
            inList.add(i);
            buildResult(start+1, num+1, n, k, inList, rtn);
            inList.remove(inList.size() - 1);
        }
    }
}