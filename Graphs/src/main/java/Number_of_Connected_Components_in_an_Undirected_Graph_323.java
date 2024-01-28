import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-27
 */
public class Number_of_Connected_Components_in_an_Undirected_Graph_323 {
    /**
     * @param n the number of nodes
     * @param edges an array that edges[i] = [ai, bi] indicates the edge between ai and bi
     * @return int - the number of connected components in the graph
     * @implSpec You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
     * Return the number of connected components in the graph.
     * @author Brian Qu
     * @since 2024-01-27 19:54
     */
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacentList.add(new ArrayList<>());
        }

        // create adjacency list
        for (int[] edge : edges) {
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adjacentList);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adjacentList) {
        visited[node] = true;
        for (int neighbor : adjacentList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjacentList);
            }
        }
    }
}
