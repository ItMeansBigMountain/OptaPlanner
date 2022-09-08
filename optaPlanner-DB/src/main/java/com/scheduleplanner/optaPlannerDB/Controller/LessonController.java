package com.scheduleplanner.optaPlannerDB.Controller;

import com.scheduleplanner.optaPlannerDB.Entity.Lesson;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class LessonController {

    @Autowired
    private LessonService lessonService;


    @PostMapping("/lessons")
    public Lesson addLesson_endpoint(@RequestBody Lesson lesson) {
        return this.lessonService.addLesson(lesson);
    }

    @DeleteMapping("/lessons/{id}")
    public Boolean deleteLesson_endpoint(@PathVariable Long id) {
        return this.lessonService.deleteLesson(id);
    }


}
