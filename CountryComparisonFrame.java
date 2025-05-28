// CountryComparisonFrame.java
// GUI for the Country Comparison game.
// Displays two countries and a metric (e.g., population).
// User selects which country has the higher value.
// Score is updated based on whether the answer is correct.
// Proceeds through all comparison questions.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CountryComparisonFrame extends JFrame {

    private CountryComparisonGame comparisonGame;
    private JLabel questionLabel;
    private JButton countryAButton;
    private JButton countryBButton;
    private JLabel feedbackLabel;
    private JLabel scoreLabel;
    private JButton backToMenuButton;

    private CountryComparisonQuestion currentQuestion;

    public CountryComparisonFrame() {
        comparisonGame = new CountryComparisonGame();

        setTitle("Country Comparison - GeoWiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Question
        questionLabel = new JLabel("Loading...", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        // Country Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        countryAButton = new JButton();
        countryBButton = new JButton();

        buttonPanel.add(countryAButton);
        buttonPanel.add(countryBButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Feedback + Score + Back Button
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        feedbackLabel = new JLabel(" ", SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);

        backToMenuButton = new JButton("Back to Menu");
        backToMenuButton.addActionListener(e -> {
            dispose();
            new MainMenuFrame();
        });

        bottomPanel.add(feedbackLabel);
        bottomPanel.add(scoreLabel);
        bottomPanel.add(backToMenuButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Button actions
        countryAButton.addActionListener((ActionEvent e) -> handleAnswer(currentQuestion.getCountryA()));
        countryBButton.addActionListener((ActionEvent e) -> handleAnswer(currentQuestion.getCountryB()));

        loadNextQuestion();
        setVisible(true);
    }

    private void loadNextQuestion() {
        if (!comparisonGame.hasMoreQuestions()) {
            questionLabel.setText("No more questions!");
            countryAButton.setEnabled(false);
            countryBButton.setEnabled(false);
            feedbackLabel.setText("Final Score: " + comparisonGame.getScoreTracker().getScore());
            return;
        }

        currentQuestion = comparisonGame.getNextQuestion();
        questionLabel.setText("Which country has higher " + currentQuestion.getMetric() + "?");
        countryAButton.setText(currentQuestion.getCountryA());
        countryBButton.setText(currentQuestion.getCountryB());
        feedbackLabel.setText(" ");
    }

    private void handleAnswer(String selectedCountry) {
        if (selectedCountry.equals(currentQuestion.getCorrectAnswer())) {
            feedbackLabel.setText("Correct!");
            comparisonGame.getScoreTracker().incrementScore();
        } else {
            feedbackLabel.setText("Incorrect. Correct answer: " + currentQuestion.getCorrectAnswer());
            comparisonGame.getScoreTracker().incrementAnswered();
        }

        scoreLabel.setText("Score: " + comparisonGame.getScoreTracker().getScore());

        Timer timer = new Timer(1500, e -> loadNextQuestion());
        timer.setRepeats(false);
        timer.start();
    }
}

