package ru.psu.dao;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.psu.dto.TestDto;
import ru.psu.generated.tables.daos.TestDao;
import ru.psu.generated.tables.pojos.Test;

import static ru.psu.generated.tables.Test.TEST;

@Repository
public class TestDaoImpl extends TestDao {

    private final DSLContext jooq;
    private final QuestionDaoImpl questionDao;

    public TestDaoImpl(DSLContext jooq, QuestionDaoImpl questionDao) {
        super(jooq.configuration());
        this.jooq = jooq;
        this.questionDao = questionDao;
    }

    public TestDto getTestByLevel(String level) {
        Test test = jooq.selectFrom(TEST)
                .where(TEST.LEVEL.eq(level))
                .fetchOneInto(Test.class);
        return new TestDto(test, questionDao.getQuestionsByTestId(test.getId()));
    }
}
