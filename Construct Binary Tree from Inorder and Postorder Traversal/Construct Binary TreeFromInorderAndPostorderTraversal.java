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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return rec(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode rec(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (instart > inend || poststart > postend) {
            return null;
        }
        int mid = postorder[postend];
        TreeNode root = new TreeNode(mid);
        int index = getIndexOf(mid, inorder);
        root.left = rec(inorder, postorder, instart, index-1, poststart, postend-1-(inend-index));
        root.right = rec(inorder, postorder, index+1, inend, postend-(inend-index), postend-1);
        return root;
    }
    
    public int getIndexOf(int x, int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == x) {
                return i;
            }
        }
        return 0;
    }
}