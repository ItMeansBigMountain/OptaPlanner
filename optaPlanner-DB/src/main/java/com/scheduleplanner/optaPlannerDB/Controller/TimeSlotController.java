package com.scheduleplanner.optaPlannerDB.Controller;

import com.scheduleplanner.optaPlannerDB.Entity.TimeSlot;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

@RestController
@CrossOrigin(origins = "*")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;


    @PostMapping("/timeslots")
    public TimeSlot addTimeSlot_endpoint(@RequestBody TimeSlot timeSlot) {
        return this.timeSlotService.addTimeSlot(timeSlot);
    }

    @DeleteMapping("/timeslots/{id}")
    public Boolean deleteTimeSlot_endpoint(@PathVariable Long id) {
        return this.timeSlotService.deleteTimeSlot(id);
    }

}
