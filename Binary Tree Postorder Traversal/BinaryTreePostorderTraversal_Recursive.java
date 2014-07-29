/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* First, the recursive solution */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rtn = new ArrayList<Integer>();
        if (root == null) return rtn;
        if (root.left != null)
            rtn.addAll(postorderTraversal(root.left));
        if (root.right != null)
            rtn.addAll(postorderTraversal(root.right));
        rtn.add(root.val);
        return rtn;
    }
}