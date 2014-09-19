public class Solution {
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, inList, rtn);
        return rtn;
    }
    public void dfs(int[] candidates, int start, int sum, List<Integer> inList, List<List<Integer>> rtn) {
        if (sum == target) {
            rtn.add(new ArrayList<Integer>(inList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - sum < candidates[i]) {
                return;
            }
            inList.add(candidates[i]);
            dfs(candidates, i, sum + candidates[i], inList, rtn);
            inList.remove(inList.size() - 1);
        }
    }
}