public class Solution {
    public int singleNumber(int[] A) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i : A) {
            if (!hs.contains(i)) {
                hs.add(i);
            } else {
                hs.remove(i);
            }
        }
        return (int)hs.iterator().next();
    }
}
