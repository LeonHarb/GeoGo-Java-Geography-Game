// Stores: metric, countryA, countryB, correctAnswer
// Defines each comparison question

public class CountryComparisonQuestion {
    private String metric; // e.g. "population", "area"
    private String countryA;
    private String countryB;
    private String correctAnswer;

    public CountryComparisonQuestion(String metric, String countryA, String countryB, String correctAnswer) {
        this.metric = metric;
        this.countryA = countryA;
        this.countryB = countryB;
        this.correctAnswer = correctAnswer;
    }

    public String getMetric() {
        return metric;
    }

    public String getCountryA() {
        return countryA;
    }

    public String getCountryB() {
        return countryB;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
