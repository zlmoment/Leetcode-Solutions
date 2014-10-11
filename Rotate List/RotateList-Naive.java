// a very naive solution
// 此题还有一种巧妙解法，首尾相连构造环，从相应处断开即可

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
    static ListNode pointer = null;
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
			return head;
		}
		pointer = head;
		ListNode fakeHead = head;
		int len = getLength(fakeHead);
		fakeHead = head;
		if (n % len == 0) {
		    return head;
		} else if (n > len) {
			rec(fakeHead, n % len);
		} else {
			rec(fakeHead, n);
		}
		ListNode mid = pointer, newHead = pointer.next;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		ListNode lastNode = pointer;
		lastNode.next = head;
		mid.next = null;
		return newHead;
	}

	public static int rec(ListNode head, int n) {
		if (head.next != null) {
			head = head.next;
			int index = rec(head, n);
			if (index == n) {
				pointer = head;
			}
			return index + 1;
		} else {
			return 0;
		}
	}
	
	public static int getLength(ListNode pointer) {
		int i = 1;
		while (pointer.next != null) {
			pointer = pointer.next;
			i++;
		}
		return i;
	}
}