// Holds a Map<String, List<String>> to represent country borders
// It supports addBorder(countryA, countryB)
// getShortestPath(start, end) using Breadth-First Search (BFS)

import java.util.*;

public class CountryGraph {
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    public void addBorder(String countryA, String countryB) {
        adjacencyList.computeIfAbsent(countryA, k -> new ArrayList<>()).add(countryB);
        adjacencyList.computeIfAbsent(countryB, k -> new ArrayList<>()).add(countryA);
    }

    public List<String> getShortestPath(String start, String end) {
        Map<String, String> prev = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(prev, end);
            }

            for (String neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    prev.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList(); // no path
    }

    private List<String> reconstructPath(Map<String, String> prev, String end) {
        List<String> path = new LinkedList<>();
        for (String at = end; at != null; at = prev.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
