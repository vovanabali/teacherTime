package com.vitgtk.teacherTime.service.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitgtk.teacherTime.domain.Teacher;
import com.vitgtk.teacherTime.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

public class UserPropertiEditor extends PropertyEditorSupport {
    @Autowired
    private UserService userService;

    public UserPropertiEditor() {

    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ObjectMapper mapper = new ObjectMapper();
        Teacher teacher = null;
        try {
            teacher = mapper.readValue(text, Teacher.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        super.setValue(teacher);
    }
}
