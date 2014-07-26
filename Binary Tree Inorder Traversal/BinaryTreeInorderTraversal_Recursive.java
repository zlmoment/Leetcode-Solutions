/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/* My Recursive solution */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rtn = new ArrayList<Integer>();
        if (root == null) return rtn;
        if (root.left != null)
            rtn.addAll(inorderTraversal(root.left));
        rtn.add(root.val);
        if (root.right != null)
            rtn.addAll(inorderTraversal(root.right));
        return rtn;
    }
}