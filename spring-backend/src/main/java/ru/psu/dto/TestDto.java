package ru.psu.dto;

import ru.psu.generated.tables.pojos.Test;

import java.util.List;

public class TestDto {

    private Integer id;
    private String  name;
    private String  level;
    List<QuestionDto> questions;

    public TestDto() {}

    public TestDto(Test test, List<QuestionDto> questions) {
        this.id = test.getId();
        this.name = test.getName();
        this.level = test.getLevel();
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
