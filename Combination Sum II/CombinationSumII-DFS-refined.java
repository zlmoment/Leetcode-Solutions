public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        dfs(num, 0, target, inList, rtn);
        return rtn;
    }
    public void dfs(int[] num, int startIndex, int target, List<Integer> inList, List<List<Integer>> rtn) {
        if (target == 0) {
            rtn.add(new ArrayList<Integer>(inList));
            return;
        }
        for (int i = startIndex; i < num.length; i++) {
            // this if statement is very important, remove the duplicates
            if (i > startIndex && num[i] == num[i-1]) {
                continue;
            }
            if (target < num[i]) {
                return;
            }
            inList.add(num[i]);
            dfs(num, i+1, target - num[i], inList, rtn);
            inList.remove(inList.size() - 1);
        }
    } 
}