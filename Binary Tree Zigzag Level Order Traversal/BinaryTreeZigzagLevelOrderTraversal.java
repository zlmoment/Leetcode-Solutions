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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if (root == null) {
            return rtn;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int direction = 0;
        while (!que.isEmpty()) {
            List<Integer> inList = new LinkedList<Integer>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (direction == 0) {
                    inList.add(node.val);
                } else {
                    inList.add(0, node.val);
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            rtn.add(inList);
            direction = (direction + 1) % 2;
        }
        return rtn;
    }
}