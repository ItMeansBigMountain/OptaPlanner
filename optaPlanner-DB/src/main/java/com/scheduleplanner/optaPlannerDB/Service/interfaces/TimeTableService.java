package com.scheduleplanner.optaPlannerDB.Service.interfaces;

import com.scheduleplanner.optaPlannerDB.Solver.TimeTable;

import java.util.List;

public interface TimeTableService {
    List<TimeTable> getAllTimeTables();

    TimeTable getLatestTimeTableById();
    TimeTable getTimeTableById(int requested_TimeTable_ID);

    TimeTable addTimeTable(TimeTable tb);

    List<TimeTable> updateTimeTable(TimeTable tb);

    TimeTable deleteTimeTable(Long id);

    void solve();
}
