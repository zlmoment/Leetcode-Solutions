// reference: http://www.programcreek.com/2013/02/leetcode-permutation-sequence-java/

public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }
        k--;
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac = fac * i;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            fac = fac / (n - i);
            int curIndex = k / fac;
            k = k % fac;
            result.append(numberList.get(curIndex));
            numberList.remove(curIndex);
        }

        return result.toString();
    }
}