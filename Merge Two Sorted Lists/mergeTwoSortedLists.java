/**
 * @author: Zhaoyu Li
 * 
**/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        
        ListNode rtn;
        if (l1.val < l2.val) {
            rtn = l1;
            l1 = l1.next;
        } else {
            rtn = l2;
            l2 = l2.next;
        }
        ListNode temp = rtn;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        temp.next = (l1 == null) ? l2 : l1;
        return rtn;
    }
}