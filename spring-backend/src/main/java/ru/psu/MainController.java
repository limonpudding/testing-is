package ru.psu;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = "application/json; charset=UTF-8")
public class MainController {

    @PostMapping("/test")
    @ResponseBody
    public TestData getTestData(@RequestBody TestParams testParams) {
        return new TestData(testParams.getLevel());
    }
}
