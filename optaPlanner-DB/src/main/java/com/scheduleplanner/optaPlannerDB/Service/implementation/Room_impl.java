package com.scheduleplanner.optaPlannerDB.Service.implementation;

import com.scheduleplanner.optaPlannerDB.Dao.RoomDao;
import com.scheduleplanner.optaPlannerDB.Entity.Room;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Room_impl implements RoomService {

    @Autowired
    private RoomDao roomDao;


    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public Room getRoomById(int requested_Room_ID) {
        return null;
    }

    @Override
    public Room addRoom(Room r) {
        return null;
    }

    @Override
    public List<Room> updateRoom(Room r) {
        return null;
    }

    @Override
    public Room deleteRoom(Long id) {
        return null;
    }
}
