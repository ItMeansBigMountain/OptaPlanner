package com.scheduleplanner.optaPlannerDB.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LessonController {

//    @Autowired
//    private LessonService lessonService;

    @RequestMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, welcome to my OPTAPLANNER DEMO Quarkus to Spring Boot conversion";
    }
}
