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
 
 /**
  * This is the WRONG edition.
  * When I tried to use Integer.parseInt, the value exceeded the maximun valune parseInt can handle, i.e. 2,147,483,647
  */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1str = "";
        String num2str = "";
        ListNode p = l1;
        num1str = Integer.toString(p.val) + num1str;
        while (p.next != null) {
            p = p.next;
            num1str = Integer.toString(p.val) + num1str;
        }
        p = l2;
        num2str = Integer.toString(p.val) + num2str;
        while (p.next != null) {
            p = p.next;
            num2str = Integer.toString(p.val) + num2str;
        }
        int num3 = Integer.parseInt(num1str) + Integer.parseInt(num2str);
        String num3str = Integer.toString(num3);
        char[] num3ary = num3str.toCharArray();
        ListNode result = new ListNode((int)(num3ary[num3ary.length - 1] - '0'));
        ListNode pointer = result;
        for (int i = num3ary.length - 2; i >= 0; i--) {
            if (i < 0) {
                break;
            }
            ListNode temp = new ListNode((int)(num3ary[i] - '0'));
            pointer.next = temp;
            pointer = temp;
        }
        return result;
    }
}