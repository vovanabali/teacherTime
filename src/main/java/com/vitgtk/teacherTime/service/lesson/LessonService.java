package com.vitgtk.teacherTime.service.lesson;

import com.vitgtk.teacherTime.domain.Lesson;
import com.vitgtk.teacherTime.domain.User;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons();

    void addLesson(Lesson lesson);

    void remuveLesson(Lesson lesson);

    Lesson getLesson(User user);
}
