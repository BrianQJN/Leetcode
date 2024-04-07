import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-07
 */
public class Reconstruct_Itinerary_332 {
    Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    /**
     * @param tickets a list of airline tickets represents the departure and the arrival airport of one flight
     * @return List<String> - the reconstructed itinerary.
     * @implSpec You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
     * All the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
     * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
     * @author Brian Qu
     * @since 2024-04-07 15:20
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // build the graph
        for (List<String> ticket: tickets) {
            flightMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flightMap.get(ticket.get(0)).add(ticket.get(1));
        }

        // start the DFS from "JFK"
        dfs("JFK");
        return res;
    }

    private void dfs(String departure) {
        PriorityQueue<String> arrivals = flightMap.get(departure);

        while (arrivals != null && !arrivals.isEmpty()) {
            // explore the next destination in lexical order
            dfs(arrivals.poll());
        }

        res.addFirst(departure);
    }
}
