package com.scheduleplanner.optaPlannerDB.Service.interfaces;

import com.scheduleplanner.optaPlannerDB.Entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons();

    Lesson getLessonById(int requested_Lesson_ID);

    Lesson addLesson(Lesson l);

    Lesson updateLesson(Lesson l);

    Boolean deleteLesson(Long id);

}
