public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
		List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        if (num.length == 0) return rtn;
        
        rtn.add(inList);
        
        for (int i = 0; i < num.length; i++) {
        	List<List<Integer>> prertn = new ArrayList<List<Integer>>();
        	prertn.addAll(rtn);
            for (List<Integer> l : prertn) {
                inList = new ArrayList<Integer>();
                inList.addAll(l);
                inList.add(num[i]);
                if (!prertn.contains(inList)) {
                	rtn.add(inList);
                }
            }
        }
        
        return rtn;
    }
}