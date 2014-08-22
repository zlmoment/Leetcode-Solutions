public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if (num.length < 3) return rtn;
        int left, right;
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            left = i + 1;
            right = num.length - 1;
            while (left < right) {
                if (num[i] + num[left] + num[right] == 0) {
                    List<Integer> l = Arrays.asList(num[i], num[left], num[right]);
                    rtn.add(l);
                    left++;
                    right--;
                    while (left < num.length && num[left] == num[left - 1]) {
                        left++;
                    }
                    while (right >= 0 && num[right] == num[right + 1]) {
                        right--;
                    }
                } else if (num[i] + num[left] + num[right] > 0) {
                    right--;
                    while (right >= 0 && num[right] == num[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left < num.length && num[left] == num[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return rtn;
    }
}