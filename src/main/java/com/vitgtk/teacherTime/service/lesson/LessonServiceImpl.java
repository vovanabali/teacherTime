package com.vitgtk.teacherTime.service.lesson;

import com.vitgtk.teacherTime.dao.LessonDao;
import com.vitgtk.teacherTime.domain.Lesson;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonDao lessonDao;

    @Override
    public List<Lesson> getAllLessons() {
        return lessonDao.getAllLessons();
    }

    @Override
    public void addLesson(Lesson lesson) {
        lessonDao.addLesson(lesson);
    }

    @Override
    public void remuveLesson(Lesson lesson) {
        remuveLesson(lesson);
    }

    @Override
    public Lesson getLesson(User user) {
        return lessonDao.getLesson(user);
    }
}
