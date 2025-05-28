// Game 1: Country Quiz Game
// It extends BaseGame
// It manages multiple-choice country quiz (e.g., capitals)
// Has a QuestionBank instance as a field to fetch questions

public class CountryQuizGame extends BaseGame {
    private QuestionBank questionBank;

    public CountryQuizGame() {
        super();
        questionBank = new QuestionBank();
    }

    @Override
    public String getGameName() {
        return "Country Quiz";
    }

    @Override
    public void start() {
        System.out.println("Starting Country Quiz Game...");
    }

    public QuestionBank getQuestionBank() {
        return questionBank;
    }
}
