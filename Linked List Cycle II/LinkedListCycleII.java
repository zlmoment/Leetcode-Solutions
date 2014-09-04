// interesting question
// reference: http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html
//            http://www.cnblogs.com/hiddenfox/p/3408931.html


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow == fast) {
                break;
            }
        }
        // no cycle
        if (fast == null) {
            return null;
        }
        
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}