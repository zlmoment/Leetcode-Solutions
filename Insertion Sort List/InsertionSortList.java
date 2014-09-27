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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), pointer = head;
        dummy.next = head;
        
        while (pointer != null && pointer.next != null) {
            if (pointer.val > pointer.next.val) {
                ListNode smallNode = pointer.next;
                ListNode pre = dummy;
                while (pre.next.val < smallNode.val) {
                    pre = pre.next;
                }
                ListNode temp = pre.next;
                pre.next = smallNode;
                pointer.next = smallNode.next;
                smallNode.next = temp;
            } else {
                pointer = pointer.next;
            }
        }
        
        return dummy.next;
    }
}