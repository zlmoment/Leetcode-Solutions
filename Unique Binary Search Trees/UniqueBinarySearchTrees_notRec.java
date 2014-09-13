// Notes

// 非常典型的一维动态规划问题
// 递归 一共n个，root是1个(可能是1:n中的一个)，左边分到比root小的i-1个，右边分到比root大的n-i个，左边的组合数*右边的组合数

// 当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
// 以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。


public class Solution {
    public int numTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int[] d = new int[n+1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                d[i] += d[j] * d[i-j-1];
            }
        }
        return d[n];
    }
}