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

		// count total number of elements
		int count = 0;
		ListNode temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}

		// break up to two list
		int middle = count / 2;
		count = 0;
		temp = head;
		ListNode l = head, r = null;
		while (temp != null) {
			count++;
			if (count == middle) {
				r = temp.next;
				temp.next = null;
				break;
			}
		}

		// now we have two parts l and r, recursively sort them
		ListNode h1 = sortList(l);
		ListNode h2 = sortList(r);

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