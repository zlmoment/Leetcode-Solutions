/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    static ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        ListNode pointer = head;
        int len = 0;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }
        return build(0, len-1);
    }
    public TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = build(start, mid-1);
        TreeNode root = new TreeNode(head.val);
        // a little bit confusing here
        head = head.next;
        TreeNode right = build(mid+1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}