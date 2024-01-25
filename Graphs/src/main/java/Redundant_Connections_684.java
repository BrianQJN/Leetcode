/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-20
 */
public class Redundant_Connections_684 {
    /**
     * @param edges the edges[i] = [a, b] represents there is an edge between node a and node b
     * @return int[] - the edge to remove
     * @implSpec In this problem, a tree is an undirected graph that is connected and has no cycles.
     * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
     * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
     * @author Brian Qu
     * @since 2024-01-20 22:41
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            // perform union-find
            if (!union(node1, node2, parent)) {
                return edge; // found the redundant edge
            }
        }

        return new int[0];
    }

    private int find(int node, int[] parent) {
        if (node != parent[node]) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }

    private boolean union(int node1, int node2, int[] parent) {
        int root1 = find(node1, parent);
        int root2 = find(node2, parent);

        if (root1 == root2) {
            return false; // cycle detected
        }

        parent[root2] = root1; // union
        return true;
    }
}

