// This interface defines the contract that all games should follow
// Methods: void start(); / String getGameName();

public interface Game {
    void start(); // Run the game logic (in CLI or via GUI)
    String getGameName();
}
