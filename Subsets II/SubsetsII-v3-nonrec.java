public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
        rtn.add(new ArrayList<Integer>());
        if(num == null || num.length == 0) {
            return rtn;
        }
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++) {
            int size = rtn.size();
            for(int j = 0; j < size; j++) {
                ArrayList<Integer> elem = new ArrayList<Integer>(rtn.get(j));
                elem.add(num[i]);
                if (!rtn.contains(elem)) {
                    rtn.add(elem);
                }
            }
        }
        return rtn;
    }
}