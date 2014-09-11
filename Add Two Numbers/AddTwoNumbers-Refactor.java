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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode rtn = new ListNode(0), pointer = rtn;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(carry % 10); // get the remainder
            pointer = pointer.next;
            carry = carry / 10; // get the carry flag
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            pointer.next = newNode;
        }
        return rtn.next;
    }
}