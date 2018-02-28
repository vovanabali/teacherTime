package com.vitgtk.teacherTime.dao;

import com.vitgtk.teacherTime.domain.TeachersLesson;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherLessonDao {
    TeachersLesson getTeacherLesson(int id);

    List<TeachersLesson> getTeacherLessons(User user);

    void addTeacherLesson(TeachersLesson teachersLesson);

    void deleteTeacherLesson(TeachersLesson teachersLesson);

    void deleteAllTeacherLessons(User user);
}
