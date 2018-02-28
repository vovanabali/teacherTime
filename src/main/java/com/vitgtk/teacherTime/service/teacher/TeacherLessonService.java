package com.vitgtk.teacherTime.service.teacher;

import com.vitgtk.teacherTime.domain.TeachersLesson;
import com.vitgtk.teacherTime.domain.User;

import java.util.List;

public interface TeacherLessonService {
    TeachersLesson getTeacherLesson(int id);

    List<TeachersLesson> getTeacherLessons(User user);

    void addTeacherLesson(TeachersLesson teachersLesson);

    void deleteTeacherLesson(TeachersLesson teachersLesson);

    void deleteAllTeacherLessons(User user);
}
