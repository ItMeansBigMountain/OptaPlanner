package com.scheduleplanner.optaPlannerDB.Controller;

import com.scheduleplanner.optaPlannerDB.Service.interfaces.TimeTableService;
import com.scheduleplanner.optaPlannerDB.Solver.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class TimeTableController {


    @Autowired
    private TimeTableService timeTableService;


    @GetMapping("/timeTable")
    public TimeTable get_timeTable_endpoint() {
        return this.timeTableService.getTimeTable();
    }

    @PostMapping("/timeTable/solve")
    public void solveTimeTable_endpoint() {
        this.timeTableService.solve();
    }

}
