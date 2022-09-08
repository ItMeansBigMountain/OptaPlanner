package com.scheduleplanner.optaPlannerDB.Service.implementation;

import com.scheduleplanner.optaPlannerDB.Service.interfaces.TimeTableService;
import com.scheduleplanner.optaPlannerDB.Solver.TimeTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTable_impl implements TimeTableService {


    @Override
    public List<TimeTable> getAllTimeTables() {
        return null;
    }

    @Override
    public TimeTable getLatestTimeTableById() {
        return null;
    }

    @Override
    public TimeTable getTimeTableById(int requested_TimeTable_ID) {
        return null;
    }

    @Override
    public TimeTable addTimeTable(TimeTable tb) {
        return null;
    }

    @Override
    public List<TimeTable> updateTimeTable(TimeTable tb) {
        return null;
    }

    @Override
    public TimeTable deleteTimeTable(Long id) {
        return null;
    }

    @Override
    public void solve() {

    }
}
