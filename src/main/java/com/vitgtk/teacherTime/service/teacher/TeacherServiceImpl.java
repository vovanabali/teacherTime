package com.vitgtk.teacherTime.service.teacher;

import com.vitgtk.teacherTime.dao.TeacherDao;
import com.vitgtk.teacherTime.dao.TeacherLessonDao;
import com.vitgtk.teacherTime.dao.UserDao;
import com.vitgtk.teacherTime.domain.Teacher;
import com.vitgtk.teacherTime.domain.TeachersLesson;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TeacherLessonDao teacherLessonDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
        /*List<Teacher> teachers = new ArrayList<>();
        List<User> users = userDao.getAllUsers();
        users.forEach(user -> {
            Teacher teacher = new Teacher();
            teacher.setTeacher(user);
            List<TeachersLesson> teachersLessons = teacherLessonDao.getTeacherLessons(user);
            teacher.setLessons(teachersLessons);
            teachers.add(teacher);
        });
        return teachers;*/
    }

    @Override
    public Teacher getTeatcherById(int id) {
        Teacher teacher = new Teacher();
        teacher.setTeacher(userDao.getUserById(id));
        teacher.setLessons(teacherLessonDao.getTeacherLessons(teacher.getTeacher()));
        return teacher;
    }

    @Override
    public Teacher getTeacherByLogin(String login) {
        Teacher teacher = new Teacher();
        teacher.setTeacher(userDao.getUserByLogin(login));
        teacher.setLessons(teacherLessonDao.getTeacherLessons(teacher.getTeacher()));
        return teacher;
    }

    @Override
    public void remuveTeacher(Teacher teacher) {
        userDao.remuveUser(teacher.getTeacher());
        teacherLessonDao.deleteAllTeacherLessons(teacher.getTeacher());
    }
}
