package ru.psu.dao;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.psu.generated.tables.daos.QuestionDao;
import ru.psu.generated.tables.pojos.Question;

import java.util.List;

import static ru.psu.generated.tables.Question.QUESTION;

@Repository
public class QuestionDaoImpl extends QuestionDao {

    private final DSLContext jooq;

    public QuestionDaoImpl(DSLContext jooq) {
        super(jooq.configuration());
        this.jooq = jooq;
    }

    public List<Question> getQuestionsByLevel(String level) {
        return jooq.selectFrom(QUESTION)
                .where(QUESTION.LEVEL.eq(level))
                .fetchInto(Question.class);
    }
}
