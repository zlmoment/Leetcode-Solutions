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
    public static void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode rightLast = root.left;
				while (rightLast.right != null) {
					rightLast = rightLast.right;
				}
				rightLast.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
}