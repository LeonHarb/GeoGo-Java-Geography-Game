// This class stores a List<Question>
// It shuffles and gives the next question
// It can be expanded to pull from an API in the future

import java.util.*;

public class QuestionBank {
    private List<Question> questions;
    private int currentIndex;

    public QuestionBank() {
        questions = new ArrayList<>();
        currentIndex = 0;
        loadSampleQuestions();
        Collections.shuffle(questions);
    }

    private void loadSampleQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "Berlin", "Rome", "Madrid"}, "Paris"));
        questions.add(new Question("What is the capital of Canada?", new String[]{"Toronto", "Ottawa", "Vancouver", "Montreal"}, "Ottawa"));
        questions.add(new Question("What is the capital of Rwanda?", new String[]{"Beirut", "Ankara", "Gitega", "Kigali"}, "Kigali"));
        questions.add(new Question("What is the capital of Lebanon?", new String[]{"Beirut", "Tripoli", "Sidon", "Byblos"},"Beirut"));
        questions.add(new Question("What is the capital of Türkiye (Turkey)?", new String[]{"Ankara", "Istanbul", "Izmir", "Bursa"},"Ankara"));
        questions.add(new Question("What is the capital of Jordan?", new String[]{"Amman", "Zarqa", "Aqaba", "Irbid"}, "Amman"));
        questions.add(new Question("What is the capital of Georgia (the country)?", new String[]{"Tbilisi", "Batumi", "Kutaisi", "Rustavi"},"Tbilisi"));
        questions.add(new Question("What is the capital of Algeria?",new String[]{"Algiers", "Oran", "Constantine", "Blida"},"Algiers"));
    }

    public Question getNextQuestion() {
        if (currentIndex < questions.size()) {
            return questions.get(currentIndex++);
        }
        return null;
    }

    public boolean hasMoreQuestions() {
        return currentIndex < questions.size();
    }
}
