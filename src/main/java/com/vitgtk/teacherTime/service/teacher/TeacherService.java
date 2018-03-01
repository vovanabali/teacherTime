package com.vitgtk.teacherTime.service.teacher;

import com.vitgtk.teacherTime.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher getTeatcherById(int id);

    Teacher getTeacherByLogin(String login);

    void remuveTeacher(Teacher teacher);

    void updateTeacherInfo(Teacher teacher );

    void updateTeacherExTime(Teacher teacher);
}
