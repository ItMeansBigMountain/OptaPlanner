package com.scheduleplanner.optaPlannerDB.Service.implementation;


import com.scheduleplanner.optaPlannerDB.Dao.LessonDao;
import com.scheduleplanner.optaPlannerDB.Entity.Lesson;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Lesson_impl implements LessonService {

    @Autowired
    private LessonDao lessonDao;


    @Override
    public List<Lesson> getAllLessons() {
        return null;
    }

    @Override
    public Lesson getLessonById(int requested_Lesson_ID) {
        return null;
    }

    @Override
    public Lesson addLesson(Lesson l) {
        return null;
    }

    @Override
    public List<Lesson> updateLesson(Lesson l) {
        return null;
    }

    @Override
    public List<Lesson> deleteLesson(int id) {
        return null;
    }
}
