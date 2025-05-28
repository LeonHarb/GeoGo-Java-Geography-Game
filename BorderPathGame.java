// Game 3: BorderPathGame
// Stores CountryGraph instance
// It uses it to find the shortest border path between two countries

import java.util.List;

public class BorderPathGame extends BaseGame {
    private CountryGraph graph;

    public BorderPathGame() {
        super();
        graph = new CountryGraph();
        setupBorders();
    }

    private void setupBorders() {
        graph.addBorder("France", "Germany");
        graph.addBorder("Germany", "Poland");
        graph.addBorder("Poland", "Ukraine");
        graph.addBorder("Ukraine", "Russia");
        graph.addBorder("France", "Spain");
        graph.addBorder("Spain", "Portugal");
        graph.addBorder("Portugal", "Morocco");
    }

    public List<String> findShortestBorderPath(String from, String to) {
        return graph.getShortestPath(from, to);
    }

    @Override
    public String getGameName() {
        return "Border Path";
    }

    @Override
    public void start() {
        System.out.println("Starting Border Path Game...");
        // GUI/CLI can ask for two countries and show the path
    }
}
