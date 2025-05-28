// Game 2: Country Comparison Game
// It compares two countries on a metric (population, area, GDP)
// It stores a list of CountryComparisonQuestion

import java.util.*;

public class CountryComparisonGame extends BaseGame {
    private List<CountryComparisonQuestion> questions;
    private int currentIndex;

    public CountryComparisonGame() {
        super();
        this.questions = new ArrayList<>();
        this.currentIndex = 0;
        loadQuestions();
        Collections.shuffle(questions);
    }

    private void loadQuestions() {
        questions.add(new CountryComparisonQuestion("population", "India", "Brazil", "India"));
        questions.add(new CountryComparisonQuestion("area", "France", "Germany", "France"));
        questions.add(new CountryComparisonQuestion("GDP", "USA", "China", "USA"));
        questions.add(new CountryComparisonQuestion("population", "Turkey", "Spain", "Turkey"));
        questions.add(new CountryComparisonQuestion("area", "Algeria", "Egypt", "Algeria"));
        questions.add(new CountryComparisonQuestion("GDP", "Germany", "Italy", "Germany"));
        
        questions.add(new CountryComparisonQuestion("population", "Lebanon", "Jordan", "Jordan"));
        questions.add(new CountryComparisonQuestion("area", "Argentina", "Mexico", "Argentina"));
        questions.add(new CountryComparisonQuestion("GDP", "Canada", "Russia", "Canada"));

        questions.add(new CountryComparisonQuestion("population", "Bangladesh", "Japan", "Bangladesh"));
        questions.add(new CountryComparisonQuestion("area", "Saudi Arabia", "Turkey", "Saudi Arabia"));
        questions.add(new CountryComparisonQuestion("GDP", "India", "United Kingdom", "India"));

        questions.add(new CountryComparisonQuestion("population", "Georgia", "Armenia", "Georgia"));
        questions.add(new CountryComparisonQuestion("area", "Ukraine", "Poland", "Ukraine"));
        questions.add(new CountryComparisonQuestion("GDP", "Australia", "Spain", "Australia"));
    }

    public CountryComparisonQuestion getNextQuestion() {
        if (currentIndex < questions.size()) {
            return questions.get(currentIndex++);
        }
        return null;
    }

    public boolean hasMoreQuestions() {
        return currentIndex < questions.size();
    }

    @Override
    public String getGameName() {
        return "Country Comparison";
    }

    @Override
    public void start() {
        System.out.println("Starting Country Comparison Game...");
        // GUI or CLI interaction will go here
    }
}
