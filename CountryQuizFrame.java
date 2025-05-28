// CountryQuizFrame.java
// GUI for the Country Quiz game.
// Shows a multiple-choice geography question (e.g., capitals).
// User selects an answer using radio buttons.
// Provides feedback and updates score using ScoreTracker.
// Loads the next question until all are answered.


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CountryQuizFrame extends JFrame {
    private CountryQuizGame quizGame;
    private ButtonGroup optionGroup;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private JLabel feedbackLabel;
    private JButton submitButton;
    private JLabel scoreLabel;
    private JButton backToMenuButton;
    private Question currentQuestion;

    public CountryQuizFrame() {
        quizGame = new CountryQuizGame();

        setTitle("Country Quiz - GeoWiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optionGroup = new ButtonGroup();
        optionButtons = new JRadioButton[4];

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(4, 1));
        feedbackLabel = new JLabel(" ", SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);

        submitButton = new JButton("Submit");
        submitButton.addActionListener((ActionEvent e) -> handleSubmit());

        backToMenuButton = new JButton("Back to Menu");
        backToMenuButton.addActionListener(e -> {
            dispose();
            new MainMenuFrame();
        });

        bottomPanel.add(feedbackLabel);
        bottomPanel.add(scoreLabel);
        bottomPanel.add(submitButton);
        bottomPanel.add(backToMenuButton);

        add(bottomPanel, BorderLayout.SOUTH);

        loadNextQuestion();
        setVisible(true);
    }

    private void loadNextQuestion() {
        currentQuestion = quizGame.getQuestionBank().getNextQuestion();

        if (currentQuestion == null) {
            questionLabel.setText("No more questions!");
            for (JRadioButton btn : optionButtons) {
                btn.setEnabled(false);
            }
            submitButton.setEnabled(false);
            feedbackLabel.setText("Final Score: " + quizGame.getScoreTracker().getScore());
            return;
        }

        questionLabel.setText(currentQuestion.getQuestionText());
        String[] choices = currentQuestion.getChoices();
        for (int i = 0; i < choices.length; i++) {
            optionButtons[i].setText(choices[i]);
            optionButtons[i].setSelected(false);
        }
        feedbackLabel.setText(" ");
    }

    private void handleSubmit() {
        if (currentQuestion == null) return;

        String selected = null;
        for (JRadioButton btn : optionButtons) {
            if (btn.isSelected()) {
                selected = btn.getText();
                break;
            }
        }

        if (selected == null) {
            feedbackLabel.setText("Please select an answer.");
            return;
        }

        if (selected.equals(currentQuestion.getCorrectAnswer())) {
            feedbackLabel.setText("Correct!");
            quizGame.getScoreTracker().incrementScore();
        } else {
            feedbackLabel.setText("Incorrect. Correct answer: " + currentQuestion.getCorrectAnswer());
        }

        scoreLabel.setText("Score: " + quizGame.getScoreTracker().getScore());

        Timer timer = new Timer(1500, e -> loadNextQuestion());
        timer.setRepeats(false);
        timer.start();
    }
}

