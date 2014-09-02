// almost the same as Binary Tree Level Order Traversal

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
        HashMap<Integer, List<Integer>> levelMap = new HashMap<Integer, List<Integer>>();
        rec(levelMap, root, 1);
        for (int i = levelMap.size(); i > 0 ; i--) {
            rtn.add(levelMap.get(i));
        }
        return rtn;
    }
    
    public static void rec(HashMap<Integer, List<Integer>> levelMap, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        addToThisLevel(levelMap, root, level);
        if (root.left != null) {
            rec(levelMap, root.left, level + 1);
        }
        if (root.right != null) {
            rec(levelMap, root.right, level + 1);
        }
    }
    
    public static void addToThisLevel(HashMap<Integer, List<Integer>> levelMap, TreeNode node, int level) {
        if (!levelMap.containsKey(level)) {
            List<Integer> inList = new ArrayList<Integer>();
            inList.add(node.val);
            levelMap.put(level, inList);
        } else {
            List<Integer> inList = levelMap.get(level);
            inList.add(node.val);
            levelMap.put(level, inList);
        }
    }
}