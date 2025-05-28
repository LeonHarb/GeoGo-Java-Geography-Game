// Stores a list of greography-related words
// Loads one into a HangWord object

import java.util.*;

public class GeographyHangmanGame extends BaseGame {
    private List<String> wordList;
    private HangmanWord currentWord;

    public GeographyHangmanGame() {
        super();
        loadWords();
        pickNewWord();
    }

    private void loadWords() {
        wordList = Arrays.asList(
            "Argentina", "Mount Everest", "Pyramids", "Amazon", "Himalayas",
            "Bangladesh", "Mississippi", "Istanbul", "Alaska", "Nile River"
        );
    }

    private void pickNewWord() {
        Collections.shuffle(wordList);
        String chosen = wordList.get(0);
        currentWord = new HangmanWord(chosen);
    }

    public boolean guessLetter(char letter) {
        return currentWord.guessLetter(letter);
    }

    public HangmanWord getCurrentWord() {
        return currentWord;
    }

    @Override
    public String getGameName() {
        return "Geography Hangman";
    }

    @Override
    public void start() {
        System.out.println("Starting Hangman Game...");
        // This is where UI or CLI loop would interact with the game
    }
}
