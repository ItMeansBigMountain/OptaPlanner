package org.com.TimePlanner.rest;

import org.com.TimePlanner.Entities.Lesson;
import org.com.TimePlanner.Entities.Room;
import org.com.TimePlanner.Entities.TimeSlot;
import org.com.TimePlanner.Entities.TimeTable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;

@Path("/timeTable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeTableResource {


    @GET
    public TimeTable getTimeTable()
    {
        return new TimeTable(   TimeSlot.listAll() , Room.listAll() , Lesson.listAll()   );
    }
}
