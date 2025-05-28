// This Question class stores: the question: String questionText, the choices: String[] choices, and the correct choice: String correctAnswer
// It is used for any game that used multiple-choice-questions

public class Question {
    private String questionText;
    private String[] choices;
    private String correctAnswer;

    public Question(String questionText, String[] choices, String correctAnswer) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getChoices() {
        return choices;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
