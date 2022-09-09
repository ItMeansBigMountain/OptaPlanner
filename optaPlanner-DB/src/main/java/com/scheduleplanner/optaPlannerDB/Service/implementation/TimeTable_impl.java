package com.scheduleplanner.optaPlannerDB.Service.implementation;

import com.scheduleplanner.optaPlannerDB.Dao.LessonDao;
import com.scheduleplanner.optaPlannerDB.Dao.RoomDao;
import com.scheduleplanner.optaPlannerDB.Dao.TimeSlotDao;
import com.scheduleplanner.optaPlannerDB.Entity.Lesson;
import com.scheduleplanner.optaPlannerDB.Entity.Room;
import com.scheduleplanner.optaPlannerDB.Entity.TimeSlot;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.TimeTableService;
import com.scheduleplanner.optaPlannerDB.Solver.TimeTable;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TimeTable_impl implements TimeTableService {

    private static final int SINGLETON_TIME_TABLE_ID = 1;

    @Inject
    SolverManager<TimeTable, Integer> solverManager;

    @Inject
    ScoreManager<TimeTable> scoreManager;


    @Autowired
    private LessonDao lessonDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private TimeSlotDao timeSlotDao;


    @Override
    public TimeTable getTimeTable() {
        SolverStatus solverStatus = solverManager.getSolverStatus(SINGLETON_TIME_TABLE_ID);
        TimeTable timeTable = findById(SINGLETON_TIME_TABLE_ID);
        scoreManager.updateScore(timeTable);
        timeTable.setSolverStatus(solverStatus);
        return timeTable;
    }


    @Override
    public void solve() {
        solverManager.solveAndListen(SINGLETON_TIME_TABLE_ID, this::findById, this::save);
    }


    @Transactional
    protected TimeTable findById(int id) {

        TimeTable tb = new TimeTable(
                this.timeSlotDao.findAll(),
                this.roomDao.findAll(),
                this.lessonDao.findAll()
        );
        return tb;
    }

    @Transactional
    protected void save(TimeTable timeTable) {
        for (Lesson lesson : timeTable.getLessonList()) {
            Optional<Lesson> attachedLesson = this.lessonDao.findById( lesson.getId() );
            if (attachedLesson.isPresent()) {
                attachedLesson.get().setTimeSlot(lesson.getTimeSlot());
                attachedLesson.get().setRoom(lesson.getRoom());
                this.lessonDao.save(attachedLesson.get());
                System.out.println(attachedLesson.get());
            }
        }
        System.out.println("-------------------");
    }
}