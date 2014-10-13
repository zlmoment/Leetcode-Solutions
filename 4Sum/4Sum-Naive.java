// use for loops

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<List<Integer>> rtn = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> intermediate = new HashSet<List<Integer>>();
        int len = num.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
    					temp.add(num[i]);
    					temp.add(num[j]);
    					temp.add(num[left]);
    					temp.add(num[right]);
                        intermediate.add(temp);
						left++;
						right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        for (List<Integer> temp : intermediate) {
            rtn.add(temp);
        }
        return rtn;
    }
}