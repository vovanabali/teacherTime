package com.vitgtk.teacherTime.dao;

import com.vitgtk.teacherTime.domain.Lesson;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonDao {
    List<Lesson> getAllLessons();

    void addLesson(Lesson lesson);

    void remuveLesson(Lesson lesson);

    Lesson getLesson(User user);
}
