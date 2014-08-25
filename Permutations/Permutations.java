public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        
        perm(rtn, tmp, num, visited);
        
        return rtn;
    }
    
    private static void perm(List<List<Integer>> rtn, List<Integer> tmp, int[] num, boolean[] visited) {
        if (tmp.size() == num.length) {
            rtn.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                tmp.add(num[i]);
                visited[i] = true;
                perm(rtn, tmp, num, visited);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
