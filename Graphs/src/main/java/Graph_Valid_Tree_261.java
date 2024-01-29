import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-27
 */
public class Graph_Valid_Tree_261 {
    /**
     * @param n the number of nodes
     * @param edges edges[i] = [ai, bi] means the edge between ai and bi
     * @return boolean - return true if the edges of the given graph make up a valid tree
     * @implSpec You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
     * Return true if the edges of the given graph make up a valid tree, and false otherwise.
     * @author Brian Qu
     * @since 2024-01-27 20:18
     */
    public boolean validTree(int n, int[][] edges) {
        // condition 1: the graph must contain n - 1 edges to form a valid tree
        if (edges.length != n - 1) return false;

        // create an adjacency list
        List<List<Integer>> adjacentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacentList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // perform DFS to check if the graph is connected and no cycle
        if (hasCycle(0, -1, visited, adjacentList)) {
            return false;
        }

        // check if all nodes are visited
        for (boolean visit : visited) {
            if (!visit) return false;
        }

        return true;
    }

    private boolean hasCycle(int node, int parent, boolean[] visited, List<List<Integer>> adjacentList) {
        visited[node] = true;
        for (int neighbor : adjacentList.get(node)) {
            // if neighbor is not visited, visit it
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, visited, adjacentList)) return true;
            } else if (neighbor != parent) {
                //if neighbor is visited and not the parent, cycle detected
                return true;
            }
        }

        return false;
    }
}