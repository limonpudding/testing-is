package ru.psu.util;

import com.fasterxml.jackson.annotation.JsonValue;

public class TestParams {

    private Level level;

    public TestParams() {

    }

    @JsonValue
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
