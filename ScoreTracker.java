// Tracks score and number of questions attempted
// Methods: incrementScore(); / incrementAnswered(); / getScore(); / getQuestionsAnswered();

public class ScoreTracker {
    private int score;
    private int questionsAnswered;

    public void incrementScore() {
        score++;
        questionsAnswered++;
    }

    public void incrementAnswered() {
        questionsAnswered++;
    }

    public int getScore() {
        return score;
    }

    public int getQuestionsAnswered() {
        return questionsAnswered;
    }
}
