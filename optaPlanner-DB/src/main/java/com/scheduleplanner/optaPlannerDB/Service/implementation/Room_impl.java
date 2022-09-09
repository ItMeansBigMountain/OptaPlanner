package com.scheduleplanner.optaPlannerDB.Service.implementation;

import com.scheduleplanner.optaPlannerDB.Dao.RoomDao;
import com.scheduleplanner.optaPlannerDB.Entity.Room;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Room_impl implements RoomService {

    @Autowired
    private RoomDao roomDao;


    @Override
    public List<Room> getAllRooms() {
        return this.roomDao.findAll();
    }

    @Override
    public Room getRoomById(int requested_Room_ID) {
        Optional<Room> r = this.roomDao.findById(requested_Room_ID);
        if (r.isEmpty()) {
            return null;
        }
        return r.get();
    }

    @Override
    public Room addRoom(Room room) {
        return this.roomDao.save(room);
    }

    @Override
    public Room updateRoom(Room r) {
        Optional<Room> q = this.roomDao.findById( r.getId() );
        if (q.isPresent()) {
            this.roomDao.save(r);
            return r;
        }
        return null;
    }

    @Override
    public Boolean deleteRoom(int id) {
        Optional<Room> q = this.roomDao.findById( id );
        if (q.isPresent()) {
            this.roomDao.deleteById( id );
            return true;
        } else return false;
    }
}
