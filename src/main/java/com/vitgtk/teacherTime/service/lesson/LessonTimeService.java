package com.vitgtk.teacherTime.service.lesson;

import com.vitgtk.teacherTime.domain.LessonTime;
import com.vitgtk.teacherTime.domain.TeachersLesson;

import java.util.List;

public interface LessonTimeService {
    LessonTime getLssonTime(int id);

    List<LessonTime> getLessonTime(TeachersLesson teachersLesson);

    void addLessonTime(LessonTime lessonTime);

    void remuveLessonTime(LessonTime lessonTime);
}
