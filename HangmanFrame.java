// HangmanFrame.java
// GUI for the Geography Hangman game.
// User guesses letters to reveal a hidden geography word.
// Tracks correct and incorrect guesses.
// Game ends when the word is guessed or max wrong guesses reached.
// Feedback is shown after each guess.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HangmanFrame extends JFrame {

    private GeographyHangmanGame hangmanGame;
    private JLabel wordLabel;
    private JTextField guessField;
    private JLabel feedbackLabel;
    private JLabel incorrectLabel;
    private JButton guessButton;
    private JButton backToMenuButton;

    public HangmanFrame() {
        hangmanGame = new GeographyHangmanGame();

        setTitle("Geography Hangman - GeoWiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        wordLabel = new JLabel("", SwingConstants.CENTER);
        wordLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
        updateWordDisplay();
        add(wordLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout());
        guessField = new JTextField(2);
        guessButton = new JButton("Guess");

        centerPanel.add(new JLabel("Enter a letter:"));
        centerPanel.add(guessField);
        centerPanel.add(guessButton);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        feedbackLabel = new JLabel(" ", SwingConstants.CENTER);
        incorrectLabel = new JLabel("Incorrect guesses: 0 / " + hangmanGame.getCurrentWord().getMaxIncorrectGuesses(), SwingConstants.CENTER);

        backToMenuButton = new JButton("Back to Menu");
        backToMenuButton.addActionListener(e -> {
            dispose();
            new MainMenuFrame();
        });

        bottomPanel.add(feedbackLabel);
        bottomPanel.add(incorrectLabel);
        bottomPanel.add(backToMenuButton);

        add(bottomPanel, BorderLayout.SOUTH);

        guessButton.addActionListener((ActionEvent e) -> handleGuess());

        setVisible(true);
    }

    private void handleGuess() {
        String input = guessField.getText().trim().toUpperCase();
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            feedbackLabel.setText("Enter a single letter A–Z.");
            return;
        }

        char guess = input.charAt(0);
        HangmanWord word = hangmanGame.getCurrentWord();

        if (word.getGuessedLetters().contains(guess)) {
            feedbackLabel.setText("You already guessed '" + guess + "'.");
            return;
        }

        boolean correct = hangmanGame.guessLetter(guess);

        if (correct) {
            feedbackLabel.setText("Correct!");
        } else {
            feedbackLabel.setText("Incorrect.");
        }

        updateWordDisplay();
        incorrectLabel.setText("Incorrect guesses: " + word.getIncorrectGuesses() + " / " + word.getMaxIncorrectGuesses());
        guessField.setText("");

        if (word.isComplete()) {
            feedbackLabel.setText("🎉 You guessed it! The word was: " + word.getTargetWord());
            guessButton.setEnabled(false);
        } else if (word.isGameOver()) {
            feedbackLabel.setText("❌ Game over! The word was: " + word.getTargetWord());
            guessButton.setEnabled(false);
        }
    }

    private void updateWordDisplay() {
        wordLabel.setText(hangmanGame.getCurrentWord().getCurrentState());
    }
}