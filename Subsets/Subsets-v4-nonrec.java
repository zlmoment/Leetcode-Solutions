public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
        rtn.add(new ArrayList<Integer>());
        if(S == null || S.length == 0) {
            return rtn;
        }
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++) {
            int size = rtn.size();
            for(int j = 0; j < size; j++) {
                ArrayList<Integer> elem = new ArrayList<Integer>(rtn.get(j));
                elem.add(S[i]);
                rtn.add(elem);
            }
        }
        return rtn;
    }
}