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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 利用快指针和慢指针实现列表分割
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        // 得到两个链表
        ListNode head1 = head, head2 = slow.next;
        slow.next = null;
        // 反转第二个链表
        ListNode index = head2, next = index.next;
        index.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = index;
            index = next;
            next = temp;
        }
        head2 = index;
        // 合并两个链表
        while (head2 != null) {
            ListNode temp = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head2.next;
            head2 = temp;
        }
    }
}