/**
 * @author: Zhaoyu Li
 * 
 * Using HashMap because HashMap has constant excution time for basic operations.
 * More about HashMap: http://goo.gl/EXp9To
 * 
 * IDEA: 
 * Iterate over the array, store numbers[i] as key and i+1 as value in hm1.
 * If numbers[i] has already in hm1, then store the corresponding pair in hm2.
 * If numbers[i] has also already in hm2, then ignore it and continue, because we
 * assume that each input would have exactly one solution.
 * 
 * Then iterate over the array again. If we assume numbers[i] + a = target, then try
 * to find a in hm1 and hm2 and get the index. Notice, if numbers[i] and a are the 
 * same, we cannot count it as index2, so if index of a is the same as i, then
 * continue finding in hm2.
 * 
**/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap hm1 = new HashMap();
        HashMap hm2 = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (!hm1.containsKey(numbers[i])) {
                hm1.put(numbers[i], i+1);
            } 
            else if (!hm2.containsKey(numbers[i])) {
                hm2.put(numbers[i], i+1);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int otherNumber = target - numbers[i];
            if (hm1.get(otherNumber) != null && (int)hm1.get(otherNumber) != i + 1) {
                return new int[] {i+1, (int)hm1.get(otherNumber)};
            }
            else if (hm2.get(otherNumber) != null) {
                return new int[] {i+1, (int)hm2.get(otherNumber)};
            }
        }
        return null;
    }
}