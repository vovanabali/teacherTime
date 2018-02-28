package com.vitgtk.teacherTime.dao;

import com.vitgtk.teacherTime.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    List<Teacher> getAllTeachers();

    Teacher getTeatcherById(int id);

    Teacher getTeacherByLogin(String login);

    void remuveTeacher(Teacher teacher);
}
