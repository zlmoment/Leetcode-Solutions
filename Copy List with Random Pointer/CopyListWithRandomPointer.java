/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        HashMap<RandomListNode, Integer> nodeToInt = new HashMap<RandomListNode, Integer>();
        HashMap<Integer, RandomListNode> intToNode = new HashMap<Integer, RandomListNode>();
        HashMap<Integer, RandomListNode> newIntToNode = new HashMap<Integer, RandomListNode>();
        HashMap<Integer, Integer> randomPair = new HashMap<Integer, Integer>();
        RandomListNode pointer = head;
        int i = 0;
        while (pointer != null) {
            nodeToInt.put(pointer, i);
            intToNode.put(i, pointer);
            pointer = pointer.next;
            i++;
        }
        for (int j = 0; j < i; j++) {
            if (intToNode.get(j).random == null) {
                randomPair.put(j, -1);
            } else {
                randomPair.put(j, nodeToInt.get(intToNode.get(j).random));
            }
        }
        i = 0;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode newPointer = newHead;
        newIntToNode.put(i, newPointer);
        while (head.next != null) {
            head = head.next;
            newPointer.next = new RandomListNode(head.label);
            newPointer = newPointer.next;
            newIntToNode.put(++i, newPointer);
        }
        for (int j = 0; j <= i; j++) {
            if (randomPair.get(j) != -1) {
                newIntToNode.get(j).random = newIntToNode.get(randomPair.get(j));
            }
        }
        return newHead;
    }
}