public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null) return 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        int max = 0;
        int counter1, counter2;
        for (int i : num) {
            hs.add(i);
        }
        for (int i = 0; i < num.length; i++) {
            counter1 = 0;
            counter2 = 0;
            while (hs.contains(num[i] + 1 + counter1)) {
                hs.remove(num[i] + 1 + counter1++);
            } 
            while (hs.contains(num[i] - 1 - counter2)) {
                hs.remove(num[i] - 1 - counter2++);
            }
            max = (counter1 + counter2 + 1 - max > 0) ? counter1 + counter2 + 1 : max; 
        }
        return max;
    }
}