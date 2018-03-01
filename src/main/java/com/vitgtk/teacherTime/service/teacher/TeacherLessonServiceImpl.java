package com.vitgtk.teacherTime.service.teacher;

import com.vitgtk.teacherTime.dao.TeacherLessonDao;
import com.vitgtk.teacherTime.domain.TeachersLesson;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherLessonServiceImpl implements TeacherLessonService {
    @Autowired
    private TeacherLessonDao teacherLessonDao;

    @Override
    public TeachersLesson getTeacherLesson(int id) {
        return teacherLessonDao.getTeacherLesson(id);
    }

    @Override
    public List<TeachersLesson> getTeacherLessons(User user) {
        return teacherLessonDao.getTeacherLessons(user);
    }

    @Override
    public void addTeacherLesson(TeachersLesson teachersLesson) {
        teacherLessonDao.addTeacherLesson(teachersLesson);
    }

    @Override
    public void deleteTeacherLesson(TeachersLesson teachersLesson) {
        teacherLessonDao.addTeacherLesson(teachersLesson);
    }

    @Override
    public void deleteAllTeacherLessons(User user) {
        teacherLessonDao.deleteAllTeacherLessons(user);
    }

    @Override
    public void updateTeacherLessons(TeachersLesson teachersLesson) {
        teacherLessonDao.updateTeacherLessons(teachersLesson);
    }
}
