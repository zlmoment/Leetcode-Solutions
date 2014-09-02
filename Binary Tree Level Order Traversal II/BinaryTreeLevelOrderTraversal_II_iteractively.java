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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rtn = new ArrayList<List<Integer>>();
        if (root == null) {
            return rtn;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currLevelNodeNum = 1;
        int nextLevelNodeNum = 0;
        while (currLevelNodeNum != 0) {
            List<Integer> currLevelResult = new ArrayList<Integer>();
            nextLevelNodeNum = 0;
            while (currLevelNodeNum != 0) {
                TreeNode node = queue.poll();
                currLevelNodeNum--;
                currLevelResult.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNodeNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNodeNum++;
                }
            }
            // add the result to the head of rtn
            rtn.add(0, currLevelResult);
            currLevelNodeNum = nextLevelNodeNum;
        }
        return rtn;
    }
}