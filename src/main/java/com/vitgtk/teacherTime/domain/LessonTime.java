package com.vitgtk.teacherTime.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class LessonTime {
    private int id;
    @NotNull
    private Date date;
    @Min(0)
    private int timeCount;
    private String info;
    private int teacher_lesson_id;

    public LessonTime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(int timeCount) {
        this.timeCount = timeCount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTeacher_lesson_id() {
        return teacher_lesson_id;
    }

    public void setTeacher_lesson_id(int teacher_lesson_id) {
        this.teacher_lesson_id = teacher_lesson_id;
    }
}
