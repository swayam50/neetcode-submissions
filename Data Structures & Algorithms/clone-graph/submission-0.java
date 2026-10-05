/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<Integer, Node>());
    }

    private Node cloneGraph(Node node, HashMap<Integer, Node> created) {
        if (node == null)
            return null;
        if (created.containsKey(node.val))
            return created.get(node.val);

        Node curr = new Node(node.val);
        created.put(node.val, curr);
        for (Node neighbor : node.neighbors)
            if (created.containsKey(neighbor.val))
                curr.neighbors.add(created.get(neighbor.val));
            else
                curr.neighbors.add(cloneGraph(neighbor, created));
        
        return curr;
    }
}