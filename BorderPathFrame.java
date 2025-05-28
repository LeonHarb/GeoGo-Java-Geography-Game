// BorderPathFrame.java
// GUI for the Border Path game.
// Allows users to choose a start and end country.
// Uses a graph-based algorithm (BFS) to calculate the shortest path through borders.
// Displays the route or an error if no path is found.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class BorderPathFrame extends JFrame {

    private BorderPathGame borderPathGame;
    private JComboBox<String> fromCombo;
    private JComboBox<String> toCombo;
    private JButton findPathButton;
    private JTextArea resultArea;
    private JButton backToMenuButton;

    public BorderPathFrame() {
        borderPathGame = new BorderPathGame();

        setTitle("Border Path - GeoWiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createTitledBorder("Select Countries"));

        fromCombo = new JComboBox<>(getCountryList());
        toCombo = new JComboBox<>(getCountryList());

        topPanel.add(new JLabel("From:"));
        topPanel.add(fromCombo);
        topPanel.add(new JLabel("To:"));
        topPanel.add(toCombo);

        add(topPanel, BorderLayout.NORTH);

        findPathButton = new JButton("Find Shortest Path");
        findPathButton.addActionListener((ActionEvent e) -> handleFindPath());
        add(findPathButton, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        bottomPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        backToMenuButton = new JButton("Back to Menu");
        backToMenuButton.addActionListener(e -> {
            dispose();
            new MainMenuFrame();
        });
        bottomPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void handleFindPath() {
        String from = (String) fromCombo.getSelectedItem();
        String to = (String) toCombo.getSelectedItem();

        if (from.equals(to)) {
            resultArea.setText("You selected the same country.");
            return;
        }

        List<String> path = borderPathGame.findShortestBorderPath(from, to);

        if (path.isEmpty()) {
            resultArea.setText("No path found between " + from + " and " + to + ".");
        } else {
            resultArea.setText("Shortest path:\n" + String.join(" → ", path));
        }
    }

    private String[] getCountryList() {
        return new String[] {
            "France", "Germany", "Poland", "Ukraine", "Russia",
            "Spain", "Portugal", "Morocco"
        };
    }
}
