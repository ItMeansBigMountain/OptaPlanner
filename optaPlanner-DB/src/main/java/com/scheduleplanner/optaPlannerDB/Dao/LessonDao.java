package com.scheduleplanner.optaPlannerDB.Dao;

import com.scheduleplanner.optaPlannerDB.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDao extends JpaRepository<Lesson, Integer> {
}
