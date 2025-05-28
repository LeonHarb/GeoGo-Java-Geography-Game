// MainMenuFrame.java
// This class displays the main menu of the GeoWiz application.
// It presents buttons to launch each of the four game modes: // Country Quiz, Country Comparison, Border Path, Geography Hangman
// Clicking a button disposes of the current window and launches the selected game's frame.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {
        setTitle("Geographun - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the window

        // Layout
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to GeograFUN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton quizButton = new JButton("Country Quiz");
        JButton comparisonButton = new JButton("Country Comparison");
        JButton borderPathButton = new JButton("Border Path");
        JButton hangmanButton = new JButton("Geography Hangman");

        // Add buttons to panel
        buttonPanel.add(quizButton);
        buttonPanel.add(comparisonButton);
        buttonPanel.add(borderPathButton);
        buttonPanel.add(hangmanButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Button listeners
        quizButton.addActionListener((ActionEvent e) -> {
            new CountryQuizFrame(); // Will create this class next
            dispose(); // Close the menu window
        });

        comparisonButton.addActionListener((ActionEvent e) -> {
            new CountryComparisonFrame(); // Create next
            dispose();
        });

        borderPathButton.addActionListener((ActionEvent e) -> {
            new BorderPathFrame(); // Create next
            dispose();
        });

        hangmanButton.addActionListener((ActionEvent e) -> {
            new HangmanFrame(); // Create next
            dispose();
        });

        setVisible(true);
    }

    // Run the app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenuFrame());
    }
}
