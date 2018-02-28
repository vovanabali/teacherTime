package com.vitgtk.teacherTime.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotEmpty;

public class Role implements GrantedAuthority {
    private int id;
    @NotEmpty
    private String name;

    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name, Integer id) {
        this.id = id;
        this.name = name;
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

    @Override
    public String getAuthority() {
        return name;
    }
}
