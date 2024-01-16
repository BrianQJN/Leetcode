import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-16
 */
public class Clone_Graph_133 {
    private Map<Node, Node> clonedNodes = new HashMap<>();

    /**
     * @param node a reference of a node in a connected undirected graph
     * @return Node - a deep copy of the graph
     * @implSpec Given a reference of a node in a connected undirected graph.
     * Return a deep copy (clone) of the graph.
     * @author Brian Qu
     * @since 2024-01-16 17:07
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // if the node is already cloned, return the clone
        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        // clone the node
        Node clone = new Node(node.val, new ArrayList<Node>());
        clonedNodes.put(node, clone);

        // clone all neighbors
        for (Node neighbor: node.neighbors) {
            // recursively call
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
