package com.scheduleplanner.optaPlannerDB.Service.interfaces;

import com.scheduleplanner.optaPlannerDB.Entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons();

    Lesson getLessonById(int requested_Lesson_ID);

    Lesson addLesson(Lesson l);

    List<Lesson> updateLesson(Lesson l);

    List<Lesson> deleteLesson(int id);

}
