package ru.psu.dto;

import ru.psu.generated.tables.pojos.Answer;

public class AnswerDto {

    private Integer id;
    private Integer questionId;
    private String  answer;
    private String  answerComment;
    private Boolean isCorrect;
    private Integer points;

    public AnswerDto() {}

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.questionId = answer.getQuestionId();
        this.answer = answer.getAnswer();
        this.answerComment = answer.getAnswerComment();
        this.isCorrect = answer.getIsCorrect();
        this.points = answer.getPoints();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerComment() {
        return answerComment;
    }

    public void setAnswerComment(String answerComment) {
        this.answerComment = answerComment;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
