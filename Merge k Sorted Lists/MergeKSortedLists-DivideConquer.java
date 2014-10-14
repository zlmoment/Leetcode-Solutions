// AC

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
    public ListNode mergeKLists(List<ListNode> lists) {
        int n = lists.size();
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return lists.get(0);
        }
        List<ListNode> leftLists = new ArrayList<ListNode>();
        List<ListNode> rightLists = new ArrayList<ListNode>();
        for (int i = 0; i < n/2; i++) {
            leftLists.add(lists.get(i));
        }
        for (int j = n/2; j < n; j++) {
            rightLists.add(lists.get(j));
        }
        ListNode l = mergeKLists(leftLists);
        ListNode r = mergeKLists(rightLists);
        return merge(l, r);
    }
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head, pointer;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        pointer = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (l1 != null) {
            pointer.next = l1;
        } else {
            pointer.next = l2;
        }
        return head;
    }
}