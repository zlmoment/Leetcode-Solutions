/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 选择数组中位数作为root节点，处理中位数以前的序列，再处理中位数以后的序列。*/

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return build(num, 0, num.length - 1);
    }
    
    public static TreeNode build(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(num[left]);
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(num[middle]);
        root.left = build(num, left, middle - 1);
        root.right = build(num, middle + 1, right);
        return root;
    }
}