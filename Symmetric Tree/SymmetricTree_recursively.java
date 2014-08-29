// Notes

// 递归实现
// 注意第33行
// 参见 http://gongxuns.blogspot.com/2012/12/leetcodesymmetric-tree.html

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null) {
            return r == null;
        }
        if (r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        if (!isSymmetric(l.left, r.right) || !isSymmetric(l.right, r.left)) {
            return false;
        }
        return true;
    }
}