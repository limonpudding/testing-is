package ru.psu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.psu.dao.QuestionDaoImpl;
import ru.psu.dao.TestDaoImpl;
import ru.psu.dto.LevelDto;
import ru.psu.dto.TestDto;
import ru.psu.enums.Level;
import ru.psu.security.UserContext;
import ru.psu.util.TestParams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestDaoImpl testDao;

    @Autowired
    QuestionDaoImpl questionDao;

    @Autowired
    UserContext userContext;

    @GetMapping("/generate")
    @ResponseBody
    public String startExamination(Level level) {
        TestDto testDto = testDao.getTestByLevel(level.name());
        userContext.getParams().put(UserContext.CURRENT_EXAMINATION_DATA, testDto);
        return "redirect:/question";
    }

    @PostMapping("/levels")
    @ResponseBody
    public List<LevelDto> levels() {
        List<LevelDto> levels = new ArrayList<>();
        for (Level level:Level.values()) {
            levels.add(new LevelDto(level));
        }
        return levels;
    }
}
