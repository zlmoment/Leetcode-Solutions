/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rec(root, 0);
        return sum;
    }
    public void rec(TreeNode root, int temp) {
        if (root == null) {
            return;
        }
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += temp;
            return;
        }
        rec(root.left, temp);
        rec(root.right, temp);
    }
}