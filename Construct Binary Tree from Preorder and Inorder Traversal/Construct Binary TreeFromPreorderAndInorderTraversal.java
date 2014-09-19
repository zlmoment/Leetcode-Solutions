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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rec(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode rec(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        int mid = preorder[prestart];
        TreeNode root = new TreeNode(mid);
        int index = getIndexOf(mid, inorder);
        root.left = rec(preorder, inorder, prestart+1, prestart+index-instart, instart, index-1);
        root.right = rec(preorder, inorder, prestart+index-instart+1, preend, index+1, inend);
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
