package com.vitgtk.teacherTime.domain;

import javax.validation.constraints.NotEmpty;

public class Group {
    private int id;
    @NotEmpty
    private String groupNamber;

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupNamber() {
        return groupNamber;
    }

    public void setGroupNamber(String groupNamber) {
        this.groupNamber = groupNamber;
    }
}
