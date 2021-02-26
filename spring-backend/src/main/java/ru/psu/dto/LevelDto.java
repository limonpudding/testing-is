package ru.psu.dto;

import ru.psu.enums.Level;

public class LevelDto {

    private String name;
    private String description;

    public LevelDto() {
    }

    public LevelDto(Level level) {
        this.name = level.name();
        this.description = level.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
