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
    public ListNode newHead, post;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = new ListNode(0), pointer = head;
        int index = 1; // start from 1
        while (pointer != null) {
            if (index == m) {
                ListNode newEnd = reverse(pointer, index, n);
                if (m == 1) {
                    head = newHead;
                }
                prev.next = newHead;
                newEnd.next = post;
                return head;
            }
            prev = pointer;
            pointer = prev.next;
            index++;
        }
        return null;
    }
    public ListNode reverse(ListNode pointer, int index, int n) {
        if (index == n) {
            newHead = pointer;
            post = pointer.next;
            return pointer;
        }
        ListNode tail = reverse(pointer.next, index+1, n);
        tail.next = pointer;
        return pointer;
    }
}