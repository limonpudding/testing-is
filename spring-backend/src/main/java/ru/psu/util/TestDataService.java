package ru.psu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.psu.dao.QuestionDaoImpl;

@Service
public class TestDataService {

    private QuestionDaoImpl questionDao;

    @Autowired
    public TestDataService(QuestionDaoImpl questionDao) {
        this.questionDao = questionDao;
    }

    public TestData collectTestDataByLevel(Level level) {
        TestData testData = new TestData();
        testData.setLevel(level);
        testData.setQuestions(questionDao.getQuestionsByLevel(level.name()));
        return testData;
    }
}
