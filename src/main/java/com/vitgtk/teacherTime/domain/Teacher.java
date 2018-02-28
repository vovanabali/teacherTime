package com.vitgtk.teacherTime.domain;

import java.util.List;

public class Teacher {
    private User teacher;
    private List<TeachersLesson> lessons;

    public Teacher() {
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<TeachersLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<TeachersLesson> lessons) {
        this.lessons = lessons;
    }
}
