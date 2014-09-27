// reverse 方法实现了O(n)的方法逆转一个单链表

// reference: http://goo.gl/tjZT5o

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                // reverse all nodes between pre and head.next;
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode start, ListNode end) {
        // reverse all nodes between start and end
        ListNode newEnd = start.next;
        ListNode pointer = newEnd.next;
        while (pointer != end) {
            newEnd.next = pointer.next;
            pointer.next = start.next;
            start.next = pointer;
            pointer = newEnd.next;
        }
        return newEnd;
    }
}