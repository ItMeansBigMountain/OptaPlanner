package com.scheduleplanner.optaPlannerDB.Service.interfaces;

import com.scheduleplanner.optaPlannerDB.Entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();

    Room getRoomById(int requested_Room_ID);

    Room addRoom(Room r);

    Room updateRoom(Room r);

    Boolean deleteRoom(int id);
}
