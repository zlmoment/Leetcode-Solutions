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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            if (head.next.val == head.val) {
                while (head.next.val == head.val) {
                    head = head.next;
                    if (head.next == null) {
                        break;
                    }
                }
                pre.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}