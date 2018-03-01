package com.vitgtk.teacherTime.service.lesson;

import com.vitgtk.teacherTime.dao.LessonTimeDao;
import com.vitgtk.teacherTime.domain.LessonTime;
import com.vitgtk.teacherTime.domain.TeachersLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonTimeServiceImpl implements LessonTimeService {
    @Autowired
    private LessonTimeDao lessonTimeDao;

    @Override
    public LessonTime getLssonTime(int id) {
        return lessonTimeDao.getLssonTime(id);
    }

    @Override
    public List<LessonTime> getLessonTime(TeachersLesson teachersLesson) {
        return lessonTimeDao.getLessonTime(teachersLesson);
    }

    @Override
    public void addLessonTime(LessonTime lessonTime) {
        lessonTimeDao.addLessonTime(lessonTime);
    }

    @Override
    public void remuveLessonTime(LessonTime lessonTime) {
        lessonTimeDao.remuveLessonTime(lessonTime);
    }

    @Override
    public void updateLessonTime(LessonTime lessonTime) {
        lessonTimeDao.updateLessonTime(lessonTime);
    }
}
