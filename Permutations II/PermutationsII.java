public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        
        dfs(rtn, inList, num, visited);
        
        return rtn;
    }
    
    private static void dfs(List<List<Integer>> rtn, List<Integer> inList, int[] num, boolean[] visited) {
        if (inList.size() == num.length) {
            rtn.add(new ArrayList<Integer>(inList));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i] == true || (i > 0 && num[i] == num[i-1] && visited[i-1] == false)) {
                continue;
            }
            visited[i] = true;
            inList.add(num[i]);
            dfs(rtn, inList, num, visited);
            inList.remove(inList.size() - 1);
            visited[i] = false;
        }
    }
}