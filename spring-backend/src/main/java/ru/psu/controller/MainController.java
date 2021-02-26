package ru.psu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.psu.dao.QuestionDaoImpl;
import ru.psu.dao.TestDaoImpl;
import ru.psu.dto.TestDto;
import ru.psu.util.TestParams;

@RestController
@RequestMapping(value = "/", produces = "application/json; charset=UTF-8")
public class MainController {

    @Autowired
    TestDaoImpl testDao;

    @Autowired
    QuestionDaoImpl questionDao;

    @PostMapping("/test")
    @ResponseBody
    public TestDto getTestData(@RequestBody TestParams testParams) {
        return testDao.getTestByLevel(testParams.getLevel().name());
    }
}
