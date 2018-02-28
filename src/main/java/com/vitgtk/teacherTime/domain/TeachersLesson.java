package com.vitgtk.teacherTime.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TeachersLesson {
    private int id;
    private int teacherId;
    @NotNull
    private Lesson lesson;
    @NotNull
    private Group group;
    @Size(min = 1, max = 1600)
    private Integer allTime;

    private List<LessonTime> exactTime;

    public TeachersLesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getAllTime() {
        return allTime;
    }

    public void setAllTime(Integer allTime) {
        this.allTime = allTime;
    }

    public List<LessonTime> getExactTime() {
        return exactTime;
    }

    public void setExactTime(List<LessonTime> exactTime) {
        this.exactTime = exactTime;
    }
}
