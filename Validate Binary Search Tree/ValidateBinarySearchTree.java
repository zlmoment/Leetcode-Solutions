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
    public int head;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validTree(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }
    public boolean validTree(int min, int max, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val > min && root.val < max && validTree(min, root.val, root.left) && validTree(root.val, max, root.right)) {
            return true;
        } else {
            return false;
        }
    }
}