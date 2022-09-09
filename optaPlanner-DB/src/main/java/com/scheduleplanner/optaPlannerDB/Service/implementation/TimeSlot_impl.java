package com.scheduleplanner.optaPlannerDB.Service.implementation;

import com.scheduleplanner.optaPlannerDB.Dao.TimeSlotDao;
import com.scheduleplanner.optaPlannerDB.Entity.TimeSlot;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlot_impl implements TimeSlotService {

    @Autowired
    private TimeSlotDao timeSlotDao;

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return this.timeSlotDao.findAll();
    }

    @Override
    public TimeSlot getTimeSlotById(int requested_TimeSlot_ID) {
        Optional<TimeSlot> ts = this.timeSlotDao.findById(requested_TimeSlot_ID);
        if (ts.isEmpty()) {
            return null;
        }
        return ts.get();
    }

    @Override
    public TimeSlot addTimeSlot(TimeSlot ts) {
        return this.timeSlotDao.save(ts);
    }

    @Override
    public TimeSlot updateTimeSlot(TimeSlot ts) {
        Optional<TimeSlot> q = this.timeSlotDao.findById( ts.getId() );
        if (q.isPresent()) {
            this.timeSlotDao.save(ts);
            return ts;
        }
        return null;
    }

    @Override
    public Boolean deleteTimeSlot(int id) {
        Optional<TimeSlot> q = this.timeSlotDao.findById( id );
        if (q.isPresent()) {
            this.timeSlotDao.deleteById( id );
            return true;
        } else return false;
    }
}
