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
        ListNode p1prev, p1, prev, p2, post;
        p1 = head;
        prev = p1;
        p2 = p1.next;
        while (p2 != null) {
            post = p2.next;
            if (p2.val < head.val) {
                prev.next = post;
                p2.next = head;
                head = p2;
                p2 = post;
            } else {
                boolean flag = true;
                while (p1 != p2) {
                    p1prev = p1;
                    p1 = p1.next;
                    if (p2.val < p1.val) {
                        prev.next = post;
                        p2.next = p1;
                        p1prev = p2;
                        prev = prev.next;
                        p2 = post;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    prev = prev.next;
                    p2 = p2.next;
                }
                p1 = head;
            }
        }
        return head;
    }
}