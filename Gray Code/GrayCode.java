// reference: http://goo.gl/1lzZw1
// Actually, I don't really understand how to use bit operation,
// just put it here and will learn deep later.

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rtn = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            rtn.add(binary2gray(i));
        }
        return rtn;
    }
    public int binary2gray(int n) {
        return (n >> 1) ^ n;
    }
}