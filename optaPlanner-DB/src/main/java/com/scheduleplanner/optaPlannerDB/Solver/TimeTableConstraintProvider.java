package com.scheduleplanner.optaPlannerDB.Solver;

import com.scheduleplanner.optaPlannerDB.Entity.Lesson;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

import java.time.Duration;

public class TimeTableConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                roomConflict(constraintFactory),
                teacherConflict(constraintFactory),
                groupConflict(constraintFactory),
                teacherTimeEfficiency(constraintFactory)
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getRoom), Joiners.lessThan(Lesson::getId))
                .penalize("Room Conflict", HardSoftScore.ofHard(1));
    }


    private Constraint teacherConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getTeacher) , Joiners.lessThan(Lesson::getId))
                .penalize("Teacher Conflict", HardSoftScore.ofHard(1));
    }


    private Constraint groupConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getStudentGroup) , Joiners.lessThan(Lesson::getId))
                .penalize("Object Group Conflict", HardSoftScore.ofHard(1));
    }


    //MAKING SURE TEACHERS ARE GIVEN CLASSES IN A ROW TO AVOID BREAKS
    //REWARD WITH SOFT SCORE++
    private Constraint teacherTimeEfficiency(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTeacher), Joiners.equal((lesson) -> lesson.getTimeSlot().getDayOfWeek()))
                .filter(
                        (lesson1, lesson2) -> {
                            Duration between = Duration.between(
                                    lesson1.getTimeSlot().getEndTime(),
                                    lesson2.getTimeSlot().getStartTime()
                            );
                            return between.isNegative() && between.compareTo(Duration.ofMinutes(30)) <= 0;
                        }
                )
                .reward("Teacher Time Efficiency", HardSoftScore.ofSoft(1));
    }


}
