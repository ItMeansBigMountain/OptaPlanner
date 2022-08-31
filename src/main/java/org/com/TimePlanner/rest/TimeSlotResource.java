package org.com.TimePlanner.rest;

import org.com.TimePlanner.Entities.TimeSlot;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/timeslots")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class TimeSlotResource {

    @POST
    public Response add(TimeSlot timeSlot) {
        TimeSlot.persist(timeSlot);
        return Response.accepted(timeSlot).build();
    }

    @DELETE
    @Path("{timeSlotId}")
    public Response delete(@PathParam("timeSlotId") Long timeSlotId) {
        TimeSlot timeSlot = TimeSlot.findById(timeSlotId);
        if (timeSlot == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        timeSlot.delete();
        return Response.status(Response.Status.OK).build();
    }


}
