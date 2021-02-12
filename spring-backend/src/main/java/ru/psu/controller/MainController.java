package ru.psu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.psu.util.TestData;
import ru.psu.util.TestDataService;
import ru.psu.util.TestParams;

@RestController
@RequestMapping(value = "/", produces = "application/json; charset=UTF-8")
public class MainController {

    @Autowired
    TestDataService testDataService;

    @PostMapping("/test")
    @ResponseBody
    public TestData getTestData(@RequestBody TestParams testParams) {
        return testDataService.collectTestDataByLevel(testParams.getLevel());
    }
}
