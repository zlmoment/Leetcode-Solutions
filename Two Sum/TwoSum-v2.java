/**
 * @author: Zhaoyu Li
 * 
 * Version 2
 *
 * Using HashMap because HashMap has constant excution time for basic operations.
 * More about HashMap: http://goo.gl/EXp9To
 * 
 * IDEA: 
 * For each number in numbers, we check if target-number[i] is already existed in
 * Hashmap, if not, we put number[i] and i into hm, if it is, then we get the two
 * indexes.
 * 
**/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();  
        int[] retVal = new int[2];  

        for(int i = 0; i < numbers.length; i++) {
            if(hm.get(target - numbers[i]) != null) {  
                retVal[0] = hm.get(target - numbers[i]) + 1;  
                retVal[1] = i + 1;  
            } else {  
                hm.put(numbers[i], i);  
            }  
        }  

        return retVal;  
    }
}