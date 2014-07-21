public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null) return 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (hm.containsKey(num[i]))
                continue;
            int prev = (hm.get(num[i] - 1) == null) ? 0 : hm.get(num[i] - 1);
            int next = (hm.get(num[i] + 1) == null) ? 0 : hm.get(num[i] + 1);
            int total = prev + next + 1;
            hm.put(num[i], total);
            hm.put(num[i] - prev, total);
            hm.put(num[i] + next, total);
            max = (total > max) ? total : max;
        }
        return max;
    }
}