package org.com.TimePlanner.solver;

import org.com.TimePlanner.Entities.Lesson;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class TimeTableConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                roomConflict(constraintFactory),
                teacherConflict(constraintFactory),
                groupConflict(constraintFactory)
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getRoom))
                .penalize("Room conflict", HardSoftScore.ofHard(1));
    }


    private Constraint teacherConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getTeacher))
                .penalize("Teacher conflict", HardSoftScore.ofHard(1));
    }


    private Constraint groupConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getStudentGroup))
                .penalize("Object Group conflict", HardSoftScore.ofHard(1));
    }


}
