/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode pointer = head;
        if (head == null) {
            return head;
        }
        ListNode headLeft = new ListNode(0);
        ListNode left = headLeft;
        ListNode headRight = new ListNode(0);
        ListNode right = headRight;
        while (pointer != null) {
            if (pointer.val < x) {
                left.next = new ListNode(pointer.val);
                left = left.next;
            } else {
                right.next = new ListNode(pointer.val);
                right = right.next;
            }
            pointer = pointer.next;
        }
        left.next = headRight.next;
        return headLeft.next;
    }
}