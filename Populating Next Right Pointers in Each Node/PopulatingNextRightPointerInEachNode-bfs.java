/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        queue.add(root);
        int count = 0, level = 0;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.remove();
            count++;
            if (count == Math.pow(2, level)) {
                node.next = null;
                count = 0;
                level++;
            } else {
                node.next = queue.element();
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}