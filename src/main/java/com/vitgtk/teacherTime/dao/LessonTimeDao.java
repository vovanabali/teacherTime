package com.vitgtk.teacherTime.dao;

import com.vitgtk.teacherTime.domain.LessonTime;
import com.vitgtk.teacherTime.domain.Teacher;
import com.vitgtk.teacherTime.domain.TeachersLesson;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface LessonTimeDao {
    LessonTime getLssonTime(int id);

    List<LessonTime> getLessonTime(TeachersLesson teachersLesson);

    void addLessonTime(LessonTime lessonTime);

    void remuveLessonTime(LessonTime lessonTime);
}
