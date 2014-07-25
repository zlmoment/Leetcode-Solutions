/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * 递归解法：
 * （1）如果二叉树为空，二叉树的深度为0
 * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return (depthLeft > depthRight) ? (depthLeft + 1) : (depthRight + 1);
    }
}