import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-08
 */
public class Network_Delay_Time_743 {
    /**
     * @param times a list of travel times as directed  edges
     * @param n the number of nodes
     * @param k the starting node
     * @return int - the minimum time it takes for all the n nodes to receive the signal, otherwise return -1.
     * @implSpec You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
     * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
     * @author Brian Qu
     * @since 2024-04-08 14:22
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time: times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]}); // {target, dis}
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];

            if (dis > dist[node]) continue;

            for (int[] edge: graph.get(node)) {
                int next = edge[0];
                int dis2 = dis + edge[1];
                if (dis2 < dist[next]) {
                    dist[next] = dis2;
                    pq.offer(new int[]{next, dis2});
                }
            }
        }

        int maxWait = 0;
        for(int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxWait = Math.max(maxWait, dist[i]);
        }

        return maxWait;
    }

    public static void main(String[] args) {
        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        Network_Delay_Time_743 test = new Network_Delay_Time_743();
        System.out.println(test.networkDelayTime(times, 4, 2));
    }
}
