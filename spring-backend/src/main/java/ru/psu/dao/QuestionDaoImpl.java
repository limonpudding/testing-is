package ru.psu.dao;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.psu.dto.QuestionDto;
import ru.psu.generated.tables.daos.QuestionDao;
import ru.psu.generated.tables.pojos.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.psu.generated.tables.Question.QUESTION;

@Repository
public class QuestionDaoImpl extends QuestionDao {

    private final DSLContext jooq;
    private final AnswerDaoImpl answerDao;

    public QuestionDaoImpl(DSLContext jooq, AnswerDaoImpl answerDao) {
        super(jooq.configuration());
        this.jooq = jooq;
        this.answerDao = answerDao;
    }

    public List<QuestionDto> getQuestionsByTestId(int testId) {
        List<Question> questionList = jooq.selectFrom(QUESTION)
                .where(QUESTION.TEST_ID.eq(testId))
                .fetchInto(Question.class);
        List<QuestionDto> questions = new ArrayList<>();
        for (Question question:questionList) {
            QuestionDto questionDto = new QuestionDto(question, answerDao.getAnswersByQuestionId(question.getTestId()));
            questions.add(questionDto);
        }
        Collections.shuffle(questions);
        return questions;
    }

    public QuestionDto getQuestionsById(int questionId) {
        Question question = jooq.selectFrom(QUESTION)
                .where(QUESTION.ID.eq(questionId))
                .fetchOneInto(Question.class);
        return new QuestionDto(question, answerDao.getAnswersByQuestionId(question.getTestId()));
    }
}
