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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        int length = 1 + way(head, head.next, n);
        return (n == length) ? head.next : head;
    }
    
    public int way(ListNode prev, ListNode temp, int n) {
        int reversedIndex = 1;
        if (temp.next != null) {
            reversedIndex = 1 + way(temp, temp.next, n);
        }
        // if found, delete the node
        if (reversedIndex == n) {
            prev.next = temp.next;
        }
        return reversedIndex;
    }
}