package org.com.TimePlanner.bootstrap;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.StartupEvent;
import org.com.TimePlanner.Entities.Lesson;
import org.com.TimePlanner.Entities.Room;
import org.com.TimePlanner.Entities.TimeSlot;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DemoDataGenerator {

    @Transactional
    public void generateDemoData(@Observes StartupEvent startupEvent) {

        // TIME SLOT DUMMY DATA
        List<TimeSlot> timeSlotList = new ArrayList<>();
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
        TimeSlot.persist(timeSlotList);


        // ROOM OBJECT DUMMY DATA
        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room("Room A"));
        roomList.add(new Room("Room B"));
        roomList.add(new Room("Room C"));
        Room.persist(roomList);


        // LESSON OBJECT DUMMY DATA
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(new Lesson("Math", "A. Turning", "9th Grade"));
        lessonList.add(new Lesson("Math", "A. Turning", "9th Grade"));
        lessonList.add(new Lesson("Physics", "M. Curie", "9th Grade"));
        lessonList.add(new Lesson("Chemistry", "M. Curie", "9th Grade"));
        lessonList.add(new Lesson("Biology", "C. Darwin", "9th Grade"));
        lessonList.add(new Lesson("History", "I. Jones", "9th Grade"));
        lessonList.add(new Lesson("English", "I. Jones", "9th Grade"));
        lessonList.add(new Lesson("English", "I. Jones", "9th Grade"));
        lessonList.add(new Lesson("Spanish", "P. Cruz", "9th Grade"));
        lessonList.add(new Lesson("Spanish", "P. Cruz", "9th Grade"));
        lessonList.add(new Lesson("Math", "A. Turning", "10th Grade"));
        lessonList.add(new Lesson("Math", "A. Turning", "10th Grade"));
        lessonList.add(new Lesson("Math", "A. Turning", "10th Grade"));
        lessonList.add(new Lesson("Physics", "M. Curie", "10th Grade"));
        lessonList.add(new Lesson("Chemistry", "M. Curie", "10th Grade"));
        lessonList.add(new Lesson("Biology", "C. Darwin", "10th Grade"));
        lessonList.add(new Lesson("History", "I. Jones", "10th Grade"));
        lessonList.add(new Lesson("English", "I. Jones", "10th Grade"));
        lessonList.add(new Lesson("English", "I. Jones", "10th Grade"));
        lessonList.add(new Lesson("Spanish", "P. Cruz", "10th Grade"));
        Lesson.persist(lessonList);
    }
}
