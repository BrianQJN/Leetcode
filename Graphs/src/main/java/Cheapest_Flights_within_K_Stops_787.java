import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-10
 */
public class Cheapest_Flights_within_K_Stops_787 {
    /**
     * @param n the number of cities
     * @param flights an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei
     * @param src the source city
     * @param dst the destination
     * @param k the maximum stop
     * @return int - the cheapest price from src to dst with at most k stops. If there is no such route, return -1
     * @implSpec There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
     * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
     * @author Brian Qu
     * @since 2024-04-10 13:33
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // relax edges K+1 times
        for (int i = 0; i <= k; i++) {
            // create a copy of dist to only consider updates from the previous iteration
            int[] distCopy = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], cost = flight[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + cost < distCopy[v]) {
                    distCopy[v] = dist[u] + cost;
                }
            }
            dist = distCopy;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        Cheapest_Flights_within_K_Stops_787 test = new Cheapest_Flights_within_K_Stops_787();
        test.findCheapestPrice(n, flights, src, dst, k);
    }
}
