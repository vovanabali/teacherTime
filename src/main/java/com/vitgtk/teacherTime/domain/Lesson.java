package com.vitgtk.teacherTime.domain;

import javax.validation.constraints.NotEmpty;

public class Lesson {
    private int id;
    @NotEmpty
    private String name;

    public Lesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
