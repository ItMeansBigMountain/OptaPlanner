package org.com.TimePlanner.rest;

import org.com.TimePlanner.Entities.Lesson;
import org.com.TimePlanner.Entities.Room;
import org.com.TimePlanner.Entities.TimeSlot;
import org.com.TimePlanner.Entities.TimeTable;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;

@Path("/timeTable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeTableResource {

    private static final long SINGLETON_TIME_TABLE_ID = 1L;

    @Inject
    SolverManager<TimeTable, Long> solverManager;

    @Inject
    ScoreManager<TimeTable, HardSoftScore> scoreManager;



    @GET
    public TimeTable getTimeTable() {
        SolverStatus solverStatus = solverManager.getSolverStatus(SINGLETON_TIME_TABLE_ID);
        TimeTable timeTable = findById(SINGLETON_TIME_TABLE_ID);
        scoreManager.updateScore(timeTable);
        timeTable.setSolverStatus(solverStatus);
        return timeTable;
    }


    @POST
    @Path("/solve")
    public void solve() {
        solverManager.solveAndListen(SINGLETON_TIME_TABLE_ID, this::findById, this::save);
    }


    @Transactional
    protected TimeTable findById(Long id) {
        return new TimeTable(
                TimeSlot.listAll(),
                Room.listAll(),
                Lesson.listAll()
        );
    }


    @Transactional
    protected void save(TimeTable timeTable) {
        for (Lesson lesson : timeTable.getLessonList()) {
            Lesson attachedLesson = Lesson.findById(lesson.getId());
            attachedLesson.setTimeSlot(lesson.getTimeSlot());
            attachedLesson.setRoom(lesson.getRoom());

            System.out.println(attachedLesson);
        }
            System.out.println("-------------------");
    }

}
