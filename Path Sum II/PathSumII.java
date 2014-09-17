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
    ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return rtn;
        }
        ArrayList<Integer> inList = new ArrayList<Integer>();
        rec(root, sum, 0, inList);
        return rtn;
    }
    public void rec(TreeNode root, int sum, int currSum, ArrayList<Integer> inList) {
        inList.add(root.val);
        if (currSum + root.val == sum && root.left == null && root.right == null) {
            rtn.add(inList);
            return;
        }
        if (root.left != null) {
            rec(root.left, sum, currSum + root.val, (ArrayList<Integer>)inList.clone());
        }
        if (root.right != null) {
            rec(root.right, sum, currSum + root.val, (ArrayList<Integer>)inList.clone());
        }
    }
}