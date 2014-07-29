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
    private TreeNode lastVisit = null;
	
	public void flatten(TreeNode root) {
		if (root == null) return;
		TreeNode savedRight = root.right;
		if (lastVisit != null) {
			lastVisit.left = null;
			lastVisit.right = root;
		}
		lastVisit = root;
		// System.out.println(lastVisit.val);
		// => 1 2 3 4 5 6
		this.flatten(root.left);
		this.flatten(savedRight);
	}
}

/* 参考 http://goo.gl/lTqMml */