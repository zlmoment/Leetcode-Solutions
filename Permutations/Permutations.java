public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        
        perm(rtn, inList, num);
        
        return rtn;
    }
    
    private static void perm(List<List<Integer>> rtn, List<Integer> inList, int[] num) {
        if (inList.size() == num.length) {
            rtn.add(new ArrayList<Integer>(inList));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (inList.contains(num[i])) {
                continue;
            }
            inList.add(num[i]);
            perm(rtn, inList, num);
            inList.remove(inList.size() - 1);
        }
    }
}