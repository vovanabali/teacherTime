package com.vitgtk.teacherTime.service.teacher;

import com.vitgtk.teacherTime.dao.*;
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
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private LessonDao lessonDao;
    @Autowired
    private LessonTimeDao lessonTimeDao;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
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

    @Override
    public void updateTeacherInfo(Teacher teacher) {
        User user = teacher.getTeacher();
        userDao.updateUser(user);
        roleDao.deleteAllRolesUser(user.getId());
        user.getRoles().forEach(role -> roleDao.setRoleToUser(user.getId(), role.getId()));
        teacher.getLessons().forEach(teachersLesson -> {
            teacherLessonDao.updateTeacherLessons(teachersLesson);
            teachersLesson.getExactTime().forEach(lessonTime -> {
                if (lessonTime.getId() == 0) {
                    lessonTimeDao.addLessonTime(lessonTime);
                } else {
                    lessonTimeDao.updateLessonTime(lessonTime);
                }
            });
        });
    }

    @Override
    public void updateTeacherExTime(Teacher teacher) {
        teacher.getLessons().forEach(teachersLesson -> teachersLesson.getExactTime().forEach(lessonTime -> {
            if (lessonTime.getId() == 0) {
                lessonTimeDao.addLessonTime(lessonTime);
            } else {
                lessonTimeDao.updateLessonTime(lessonTime);
            }
        }));
    }
}
