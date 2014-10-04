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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<Integer> vals = new ArrayList<Integer>();
        inOrderTraverse(root, list, vals);
        Collections.sort(vals);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = vals.get(i);
        }
    }
        
    public void inOrderTraverse(TreeNode node, List<TreeNode> list, List<Integer> vals) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left, list, vals);
        list.add(node);
        vals.add(node.val);
        inOrderTraverse(node.right, list, vals);
    }
}