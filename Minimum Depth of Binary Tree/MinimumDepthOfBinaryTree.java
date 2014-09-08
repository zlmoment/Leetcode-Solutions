// similar to Sum Root to Leaf Numbers

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
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rec(root, 0);
        return minDepth;
    }
    public void rec(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            if (depth < minDepth) {
                minDepth = depth;
            }
        }
        rec(root.left, depth);
        rec(root.right, depth);
    }
}