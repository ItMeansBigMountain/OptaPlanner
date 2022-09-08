package com.scheduleplanner.optaPlannerDB.Controller;

import com.scheduleplanner.optaPlannerDB.Entity.Room;
import com.scheduleplanner.optaPlannerDB.Service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping("/rooms")
    public Room addRoom_endpoint(Room room) {
        return roomService.addRoom(room);
    }

    @DeleteMapping("/rooms/{id}")
    public Room deleteRoom_endpoint(@PathVariable Long id ) {
        return roomService.deleteRoom(id) ;
    }


}
