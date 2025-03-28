/*
// Definition for a Node.
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

    HashMap<Node, Node> newHashMap = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        // If find the visited node in new hash map
        if (newHashMap.containsKey(node)) {
            return newHashMap.get(node); // Get the corresponding new node from the original node
        }

        // Create a new node with empty list, and put into new graph
        Node newNode = new Node(node.val, new ArrayList());
        newHashMap.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }
}