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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode cur = head, l = head, r = head.next;
        while (cur != null && cur.next != null) {
            l.next = r.next;
            r.next = l;
            cur = cur.next;
            if (cur != null && cur.next != null) {
                l.next = cur.next;
                l = cur;
                r = cur.next;
            }
        }
        return newHead;
    }
}