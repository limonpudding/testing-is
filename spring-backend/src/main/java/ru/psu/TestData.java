package ru.psu;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    private Level level;
    private List<Question> questions;

    public TestData() {

    }

    public TestData(Level level) {
        this.level = level;
        questions = new ArrayList<>();
        Question question1 = new Question();
        question1.setLevel(level);
        question1.setText("Вопрос 1");
        question1.setAnswer1("Ответ 1");
        question1.setAnswer2("Ответ 2");
        question1.setAnswer3("Ответ 3");
        question1.setAnswer4("Ответ 4");
        question1.setCorrectAnswer(3);
        questions.add(question1);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
