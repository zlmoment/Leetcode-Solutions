public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for (int i : A) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
            } else {
                hm.remove(i);
            }
        }
        for (int key : hm.keySet()) {
            return key;
        }
        return 0;
    }
}
