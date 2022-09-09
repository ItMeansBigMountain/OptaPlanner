package com.scheduleplanner.optaPlannerDB.Service.interfaces;

import com.scheduleplanner.optaPlannerDB.Entity.TimeSlot;

import java.util.List;

public interface TimeSlotService {
    List<TimeSlot> getAllTimeSlots();

    TimeSlot getTimeSlotById(int requested_TimeSlot_ID);

    TimeSlot addTimeSlot(TimeSlot ts);

    TimeSlot updateTimeSlot(TimeSlot ts);

    Boolean deleteTimeSlot(int id);
}
