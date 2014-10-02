// dfs Time limitation exceeded

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        dfs(num, 0, 0, target, inList, rtn);
        return rtn;
    }
    public void dfs(int[] num, int startIndex, int sum, int target, List<Integer> inList, List<List<Integer>> rtn) {
        if (sum == target) {
            rtn.add(new ArrayList<Integer>(inList));
            return;
        }
        for (int i = startIndex; i < num.length; i++) {
            inList.add(num[i]);
            dfs(num, i+1, sum + num[i], target, inList, rtn);
            inList.remove(inList.size() - 1);
        }
    } 
}