public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, inList, rtn);
        return rtn;
    }
    public void dfs(int[] candidates, int start, int target, List<Integer> inList, List<List<Integer>> rtn) {
        if (target == 0) {
            rtn.add(new ArrayList<Integer>(inList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            inList.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], inList, rtn);
            inList.remove(inList.size() - 1);
        }
    }
}