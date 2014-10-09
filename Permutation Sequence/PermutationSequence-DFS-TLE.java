// DFS  Time Limitation Exceeded

public class Solution {
    public String getPermutation(int n, int k) {
        List<List<Integer>> all = getPermutations(n);
        List<Integer> result = all.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i);
        }
        return sb.toString();
    }
    
    public static List<List<Integer>> getPermutations(int n) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        rec(rtn, inList, n);
        return rtn;
    }
    
    public static void rec(List<List<Integer>> rtn, List<Integer> inList, int n) {
        if (inList.size() == n) {
            rtn.add(new ArrayList(inList));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (inList.contains(i)) {
                continue;
            }
            inList.add(i);
            rec(rtn, inList, n);
            inList.remove(inList.size() - 1);
        }
    }
}