package ru.psu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.psu.dao.QuestionDaoImpl;
import ru.psu.dao.TestDaoImpl;
import ru.psu.dto.QuestionDto;
import ru.psu.dto.TestDto;
import ru.psu.security.UserContext;
import ru.psu.util.QuestionParams;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionDaoImpl questionDao;

    @Autowired
    UserContext userContext;

    @Autowired
    TestDaoImpl testDao;

    @RequestMapping("/first")
    public QuestionDto getFirst() {

        return questionDao.getQuestionsById(1);
    }

    @RequestMapping("/next")
    public QuestionDto getNext() {
        TestDto test = (TestDto) userContext.getParams().get(UserContext.CURRENT_EXAMINATION_DATA);
        return test.getQuestions().get(0);
    }

    @PostMapping("/question")
    @ResponseBody
    public QuestionDto getQuestion(@RequestBody QuestionParams questionParams) {
        TestDto test = (TestDto) userContext.getParams().get(UserContext.CURRENT_EXAMINATION_DATA);
        if (test == null) {
            test = testDao.getTestByLevel(questionParams.getLevel().name());
            userContext.getParams().put(UserContext.CURRENT_EXAMINATION_DATA, test);
        }
        return test.getQuestions().get(questionParams.getOrdinal());
    }
}
