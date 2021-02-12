package ru.psu.util;

public enum Level {
    EASY("Лёгкий уровень"),
    NORMAL("Нормальный уровень"),
    HARD("Сложный уровень");

    private String description;

    Level(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
