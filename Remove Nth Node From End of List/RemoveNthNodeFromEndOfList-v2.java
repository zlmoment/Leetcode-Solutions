// Two pointers

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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int count = 0;
        while(fast.next != null) {
            if(count >= n)
                slow = slow.next;
            fast = fast.next;
            count++;
        }
        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}