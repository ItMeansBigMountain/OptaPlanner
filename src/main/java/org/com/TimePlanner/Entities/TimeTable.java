package org.com.TimePlanner.Entities;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

import java.util.List;




@PlanningSolution
public class TimeTable {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id="timeslotRange")
    private List<TimeSlot> timeSlotList;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id="roomRange")
    private List<Room> roomList;

    @PlanningEntityCollectionProperty
    private List<Lesson> lessonList;

    @PlanningScore
    private HardSoftScore score;


    private SolverStatus solverStatus;

    public TimeTable() {
    }


    public TimeTable(List<TimeSlot> timeSlotList, List<Room> roomList, List<Lesson> lessonList) {
        this.timeSlotList = timeSlotList;
        this.roomList = roomList;
        this.lessonList = lessonList;
    }


    public List<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(List<TimeSlot> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public SolverStatus getSolverStatus() {
        return solverStatus;
    }

    public void setSolverStatus(SolverStatus solverStatus) {
        this.solverStatus = solverStatus;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
