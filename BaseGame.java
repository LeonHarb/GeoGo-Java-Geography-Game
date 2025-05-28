// This class implements the interface Game
// It has a ScoreTracker instance as a field
// All specific games inherit from this (extend this class)

public abstract class BaseGame implements Game {
    protected ScoreTracker scoreTracker;

    public BaseGame() {
        this.scoreTracker = new ScoreTracker();
    }

    public ScoreTracker getScoreTracker() {
        return scoreTracker;
    }
}
