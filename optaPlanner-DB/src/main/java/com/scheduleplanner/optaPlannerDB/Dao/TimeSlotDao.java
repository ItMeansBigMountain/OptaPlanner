package com.scheduleplanner.optaPlannerDB.Dao;

import com.scheduleplanner.optaPlannerDB.Entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotDao extends JpaRepository<TimeSlot, Integer> {
}
