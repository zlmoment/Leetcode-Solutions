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
        if (head == null) {
            return head;
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        ListNode pointer = head;
        ListNode prev = head;
        while (pointer != null) {
            if (!hs.contains(pointer.val)) {
                hs.add(pointer.val);
                prev = pointer;
                pointer = pointer.next;
            } else {
                pointer = pointer.next;
                prev.next = pointer;
            }
        }
        return head;
    }
}