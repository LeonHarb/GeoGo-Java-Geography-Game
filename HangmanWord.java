// Manages the game state for one word: The word itself, guessed letters, and number of incorrect guesses
// Methods: guessLetter (char c); / isComplete(); / isGameOver(); / getCurrentState();

import java.util.HashSet;
import java.util.Set;

public class HangmanWord {
    private String targetWord;
    private Set<Character> guessedLetters;
    private int incorrectGuesses;

    private static final int MAX_INCORRECT = 6;

    public HangmanWord(String word) {
        this.targetWord = word.toUpperCase();
        this.guessedLetters = new HashSet<>();
        this.incorrectGuesses = 0;
    }

    public boolean guessLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (guessedLetters.contains(letter)) return false;

        guessedLetters.add(letter);
        if (!targetWord.contains(String.valueOf(letter))) {
            incorrectGuesses++;
            return false;
        }
        return true;
    }

    public boolean isComplete() {
        for (char c : targetWord.toCharArray()) {
            if (Character.isLetter(c) && !guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return incorrectGuesses >= MAX_INCORRECT || isComplete();
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public String getCurrentState() {
        StringBuilder sb = new StringBuilder();
        for (char c : targetWord.toCharArray()) {
            if (!Character.isLetter(c)) {
                sb.append(c); // keep spaces/punctuation
            } else if (guessedLetters.contains(c)) {
                sb.append(c);
            } else {
                sb.append('_');
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public String getTargetWord() {
        return targetWord;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public int getMaxIncorrectGuesses() {
        return MAX_INCORRECT;
    }
}
