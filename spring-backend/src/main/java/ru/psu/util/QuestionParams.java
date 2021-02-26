package ru.psu.util;

import ru.psu.enums.Level;

import java.io.Serializable;

public class QuestionParams implements Serializable {

    private int ordinal;
    private Level level;

    public QuestionParams() {

    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
