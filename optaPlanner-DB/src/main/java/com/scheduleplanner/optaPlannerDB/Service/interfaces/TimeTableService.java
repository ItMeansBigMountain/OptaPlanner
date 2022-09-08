package com.scheduleplanner.optaPlannerDB.Service.interfaces;

import com.scheduleplanner.optaPlannerDB.Solver.TimeTable;

import java.util.List;

public interface TimeTableService {

    TimeTable getLatestTimeTableById();

    void solve();
}
