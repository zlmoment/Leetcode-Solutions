// 用i记录0应该放的位置，j记录2应该放的位置。
// cur从0到j扫描，
// 遇到0，放在i位置，i后移；
// 遇到2，放在j位置，j前移；
// 遇到1，cur后移。
// 扫描一遍得到排好序的数组。
// reference: http://blog.unieagle.net/2012/10/23/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Asort-colors/

// Another solution here: http://www.darrensunny.me/leetcode-sort-colors/

public class Solution {
    public void sortColors(int[] A) {
        if (A.length < 1) {
            return;
        }
        int i = 0, j = A.length - 1;
        int cur = 0;
        while (cur <= j) {
            if (A[cur] == 0) {
                swap(A, i++, cur++);
            } else if (A[cur] == 2) {
                swap(A, j--, cur);
            } else {
                cur++;
            }
        }
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}