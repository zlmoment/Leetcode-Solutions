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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode rtn = new ListNode(0), pointer = rtn;
        boolean flag_carry = false;
        while (l1 != null && l2 != null) {
            int temp = 0;
            if (l1.val + l2.val >= 10) {
                temp = flag_carry ? l1.val + l2.val - 10 + 1 : l1.val + l2.val - 10;
                flag_carry = true;
            } else {
                temp = flag_carry ? l1.val + l2.val + 1 : l1.val + l2.val;
                if (temp >= 10) {
                    flag_carry = true;
                    temp -= 10;
                } else {
                    flag_carry = false;
                }
            }
            ListNode newNode = new ListNode(temp);
            pointer.next = newNode;
            pointer = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int temp = 0;
            if (flag_carry) {
                if (l1.val + 1 >= 10) {
                    temp = l1.val + 1 - 10;
                    flag_carry = true;
                } else {
                    temp = l1.val + 1;
                    flag_carry = false;
                }
            } else {
                temp = l1.val;
            }
            ListNode newNode = new ListNode(temp);
            pointer.next = newNode;
            pointer = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int temp = 0;
            if (flag_carry) {
                if (l2.val + 1 >= 10) {
                    temp = l2.val + 1 - 10;
                    flag_carry = true;
                } else {
                    temp = l2.val + 1;
                    flag_carry = false;
                }
            } else {
                temp = l2.val;
            }
            ListNode newNode = new ListNode(temp);
            pointer.next = newNode;
            pointer = newNode;
            l2 = l2.next;
        }
        if (flag_carry) {
            ListNode newNode = new ListNode(1);
            pointer.next = newNode;
        }
        return rtn.next;
    }
}