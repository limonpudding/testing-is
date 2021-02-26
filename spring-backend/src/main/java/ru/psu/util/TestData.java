package ru.psu.util;

import ru.psu.generated.tables.pojos.Question;
import ru.psu.enums.Level;

import java.util.List;

public class TestData {

    private Level level;
    private List<Question> questions;

    public TestData() {}

    public TestData(Level level, List<Question> questions) {
        this.level = level;
        this.questions = questions;
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
