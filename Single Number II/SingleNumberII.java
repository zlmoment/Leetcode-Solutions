public class Solution {
    public int singleNumber(int[] A) {
        if (A.length == 0)
            return -1;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : A) {
            if (hm.containsKey(i))
                hm.put(i, hm.get(i) + 1);
            else
                hm.put(i, 1);
        }
        Set<Map.Entry<Integer, Integer>> en = hm.entrySet();
        for (Map.Entry<Integer, Integer> e : en) {
            if (e.getValue() == 1)
                return e.getKey();
        }
        return -1;
    }
}