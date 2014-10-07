// reference: http://www.programcreek.com/2012/12/leetcode-clone-graph-java/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, newHead);
        while (!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.pop();
            for (UndirectedGraphNode temp : currNode.neighbors) {
                if (map.containsKey(temp)) {
                    map.get(currNode).neighbors.add(map.get(temp));
                } else {
                    queue.add(temp);
                    UndirectedGraphNode copy = new UndirectedGraphNode(temp.label);
                    map.put(temp, copy);
                    map.get(currNode).neighbors.add(copy);
                }
            }
        }
        return newHead;
    }
}