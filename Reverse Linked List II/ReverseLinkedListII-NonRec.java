// 参考了在 ReverseNodesInKGroup-NonRec 中reverse linked list的方法，见 http://goo.gl/eluvBb

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy, end = head;
        int i = 0;
        while (head != null) {
            i++;
            if (i == m - 1) {
                start = head;
            }
            if (i == n) {
                end = head.next;
            }
            head = head.next;
        }
        reverse(start, end);
        return dummy.next;
    }
    public void reverse(ListNode start, ListNode end) {
        ListNode newEnd = start.next;
        ListNode pointer = newEnd.next;
        while (pointer != end) {
            newEnd.next = pointer.next;
            pointer.next = start.next;
            start.next = pointer;
            pointer = newEnd.next;
        }
    }
}