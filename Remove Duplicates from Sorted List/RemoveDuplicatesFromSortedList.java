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
        if (head == null) return head;
        HashSet<Integer> hs = new HashSet<Integer>();
        ListNode temp = head;
        ListNode prev = head;
        while (temp.next != null) {
            if (!hs.contains(temp.val)) {
                hs.add(temp.val);
                prev = temp;
                temp = temp.next;
            } else {
                temp = temp.next;
                prev.next = temp;
            }
        }
        if (hs.contains(temp.val)) {
            temp = temp.next;
            prev.next = temp;
        }
        return head;
    }
}