// http://blog.csdn.net/kenden23/article/details/14106137

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return (total < 0) ? -1 : index + 1;
    }
}