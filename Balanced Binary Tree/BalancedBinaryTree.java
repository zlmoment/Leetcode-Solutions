// Notes

// 递归解答

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
    public boolean isBalanced(TreeNode root) {
        if (getDep(root) == -1) {
            return false;
        }
        return true;
    }
    
    public static int getDep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = getDep(root.left);
        int right = getDep(root.right);
        
        if (left == -1 || right == -1) {
            return -1;
        }
        
        if (Math.abs(left - right) > 1) {
			return -1;
		}
		
		return Math.max(left, right) + 1;
    }
}