// Notes

// 广度优先遍历，利用next指针构建一个新的queue

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        int width = 1, num = 0;
        TreeLinkNode head = root, tail = root;
        while (head != null) {
            if (head.left != null) {
                tail.next = head.left;
                tail = head.left;
            }
            if (head.right != null) {
                tail.next = head.right;
                tail = head.right;
            }
            num++;
            if (num == width) {
                TreeLinkNode temp = head;
                head = temp.next;
                temp.next = null;
                num = 0;
                width *= 2;
            } else {
                head = head.next;
            }
        }
    }
}