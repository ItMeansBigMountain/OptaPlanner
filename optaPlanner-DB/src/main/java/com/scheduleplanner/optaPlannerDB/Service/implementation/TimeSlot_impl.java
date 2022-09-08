package com.scheduleplanner.optaPlannerDB.Service.implementation;

import com.scheduleplanner.optaPlannerDB.Dao.TimeSlotDao;
import com.scheduleplanner.optaPlannerDB.Entity.TimeSlot;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlot_impl implements TimeSlotService {

    @Autowired
    private TimeSlotDao timeSlotDao;

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return null;
    }

    @Override
    public TimeSlot getTimeSlotById(int requested_TimeSlot_ID) {
        return null;
    }

    @Override
    public TimeSlot addTimeSlot(TimeSlot ts) {
        return null;
    }

    @Override
    public List<TimeSlot> updateTimeSlot(TimeSlot ts) {
        return null;
    }

    @Override
    public TimeSlot deleteTimeSlot(Long id) {
        return null;
    }
}
