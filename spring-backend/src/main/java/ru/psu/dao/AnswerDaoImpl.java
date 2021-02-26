package ru.psu.dao;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.psu.dto.AnswerDto;
import ru.psu.generated.tables.daos.AnswerDao;
import ru.psu.generated.tables.pojos.Answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.psu.generated.tables.Answer.ANSWER;

@Repository
public class AnswerDaoImpl extends AnswerDao {

    private final DSLContext jooq;

    public AnswerDaoImpl(DSLContext jooq) {
        super(jooq.configuration());
        this.jooq = jooq;
    }

    public List<AnswerDto> getAnswersByQuestionId(int questionId) {
        List<Answer> answerList = jooq.selectFrom(ANSWER)
                .where(ANSWER.QUESTION_ID.eq(questionId))
                .fetchInto(Answer.class);
        List<AnswerDto> answers = new ArrayList<>();
        for (Answer answer:answerList) {
            answers.add(new AnswerDto(answer));
        }
        Collections.shuffle(answers);
        return answers;
    }
}
