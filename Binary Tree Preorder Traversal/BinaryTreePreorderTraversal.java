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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rtn = new ArrayList<Integer>();
        if (root == null)
            return rtn;
        rtn.add(root.val);
        if (root.left != null)
            rtn.addAll(preorderTraversal(root.left));
        if (root.right != null)
            rtn.addAll(preorderTraversal(root.right));
        return rtn;
    }
}