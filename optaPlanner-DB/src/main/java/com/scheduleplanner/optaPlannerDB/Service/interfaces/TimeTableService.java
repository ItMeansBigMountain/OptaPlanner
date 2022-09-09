package com.scheduleplanner.optaPlannerDB.Service.interfaces;

import com.scheduleplanner.optaPlannerDB.Solver.TimeTable;

public interface TimeTableService {

    TimeTable getTimeTable();

    void solve();
}
