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
    int max;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            max = 0;
        } else {
            max = root.val;
        }
        findMax(root);
        return max;
    }
    
    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(findMax(root.left), 0);
        int right = Math.max(findMax(root.right), 0);
        max = Math.max(root.val + left + right, max);
        return root.val + Math.max(left, right);
    }
}