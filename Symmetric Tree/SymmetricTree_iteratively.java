// Notes

// 利用queue实现广度优先遍历
// 采用了两个queue，巧妙实现对每一行进行对比是不是对称
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
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        LinkedList<TreeNode> r = new LinkedList<TreeNode>();
        l.add(root.left);
        r.add(root.right);
        while (!l.isEmpty() && !r.isEmpty()) {
            TreeNode temp1 = l.poll();
            TreeNode temp2 = r.poll();
            if (temp1 != null && temp2 != null) {
                if (temp1.val != temp2.val) {
                    return false;
                }
                l.add(temp1.left);
                l.add(temp1.right);
                r.add(temp2.right);
                r.add(temp2.left);
            } else if (!(temp1 == null && temp2 == null)) {
                return false;
            }
        }
        return true;
    }
}