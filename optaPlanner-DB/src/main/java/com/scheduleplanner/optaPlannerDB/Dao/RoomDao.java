package com.scheduleplanner.optaPlannerDB.Dao;

import com.scheduleplanner.optaPlannerDB.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<Room, Integer> {
}
