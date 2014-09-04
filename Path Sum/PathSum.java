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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return rec(root, sum, 0);
    }
    public static boolean rec(TreeNode root, int sum, int currSum) {
        if (currSum + root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        boolean left = false, right = false;
        if (root.left != null) {
            left = rec(root.left, sum, currSum + root.val);
        }
        if (root.right != null) {
            right = rec(root.right, sum, currSum + root.val);
        }
        if (left == true || right == true) {
            return true;
        }
        return false;
    }
}