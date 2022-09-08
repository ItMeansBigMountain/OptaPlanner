package com.scheduleplanner.optaPlannerDB.Service.implementation;


import com.scheduleplanner.optaPlannerDB.Dao.LessonDao;
import com.scheduleplanner.optaPlannerDB.Entity.Lesson;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Lesson_impl implements LessonService {

    @Autowired
    private LessonDao lessonDao;


    @Override
    public List<Lesson> getAllLessons() {
        return this.lessonDao.findAll();
    }

    @Override
    public Lesson getLessonById(int requested_Lesson_ID) {
        Optional<Lesson> a = this.lessonDao.findById(requested_Lesson_ID);
        if (a.isEmpty()) {
            return null;
        }
        return a.get();
    }

    @Override
    public Lesson addLesson(Lesson l) {
        return this.lessonDao.save(l);
    }

    @Override
    public Lesson updateLesson(Lesson l) {
        Optional<Lesson> q = this.lessonDao.findById(Math.toIntExact(l.getId()));
        if (q.isPresent()) {
            this.lessonDao.save(l);
            return l;
        }
        return null;
    }

    @Override
    public Boolean deleteLesson(Long id) {
        Optional<Lesson> q = this.lessonDao.findById(Math.toIntExact(id));
        if (q.isPresent()) {
            this.lessonDao.deleteById(Math.toIntExact(id));
            return true;
        } else return false;
    }
}
