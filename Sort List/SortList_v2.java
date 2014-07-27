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
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// break up to two list
		// 使用追及问题来分LinkedList
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
		    fast = fast.next.next;
		    slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;

		// now we have two parts head and fast, recursively sort them
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(fast);

		// merge together
		return merge(h1, h2);
	}

	public static ListNode merge(ListNode l, ListNode r) {
		if (l == null)
			return r;
		else if (r == null)
			return l;

		ListNode rtn;
		if (l.val < r.val) {
			rtn = l;
			l = l.next;
		} else {
			rtn = r;
			r = r.next;
		}
		ListNode temp = rtn;
		while (l != null && r != null) {
			if (l.val < r.val) {
				temp.next = l;
				temp = temp.next;
				l = l.next;
			} else {
				temp.next = r;
				temp = temp.next;
				r = r.next;
			}
		}
		temp.next = (l == null) ? r : l;
		return rtn;
	}
}