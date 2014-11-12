public class Solution {
    ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if(num == null) {
            return null;
        }
        Arrays.sort(num);
        helper(num, num.length - 1);
        return rtn;
    }
    public void helper(int[] num, int index) {
        if(index == -1) {
            // add the empty element
            rtn.add(new ArrayList<Integer>());
            return;
        }
        helper(num, index - 1);
        int size = rtn.size();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> elem = new ArrayList<Integer>(rtn.get(i));
            elem.add(num[index]);
            // 注意：添加的东东在这里
            if (!rtn.contains(elem)) {
                rtn.add(elem);
            }
        }
    }
}