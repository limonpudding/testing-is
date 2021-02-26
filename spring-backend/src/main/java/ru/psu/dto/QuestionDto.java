package ru.psu.dto;

import ru.psu.generated.tables.pojos.Question;

import java.util.List;

public class QuestionDto {

    private Integer id;
    private Integer testId;
    private Integer questionNumber;
    private String  questionText;
    private List<AnswerDto> answers;

    private final int BEST_ANSWER_POINTS = 10;
    private final int GOOD_ANSWER_POINTS = 5;

    public QuestionDto() {}

    public QuestionDto(Question question, List<AnswerDto> answers) {
        this.id = question.getId();
        this.testId = question.getTestId();
        this.questionNumber = question.getQuestionNumber();
        this.questionText = question.getQuestionText();
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }

    public AnswerDto getBestAnswer() {
        for (AnswerDto answer:answers) {
            if (answer.getCorrect() && answer.getPoints().equals(BEST_ANSWER_POINTS)) {
                return answer;
            }
        }
        return null; // тупа нэрэально
    }

    public AnswerDto getGoodAnswer() {
        for (AnswerDto answer:answers) {
            if (answer.getCorrect() && answer.getPoints().equals(GOOD_ANSWER_POINTS)) {
                return answer;
            }
        }
        return null; // тупа нэрэально
    }
}
