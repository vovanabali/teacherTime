package com.vitgtk.teacherTime.service.security;

import com.vitgtk.teacherTime.domain.Role;
import com.vitgtk.teacherTime.service.role.RoleService;

import java.beans.PropertyEditorSupport;

public class UserRolePropertyEditor extends PropertyEditorSupport {
    private RoleService roleService;

    public UserRolePropertyEditor(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Integer id = new Integer(text);
        Role role = roleService.getRoleById(id);
        super.setValue(role);
    }

    @Override
    public String getAsText() {
        if (getValue() instanceof Role) {
            return String.valueOf(((Role) getValue()).getId());
        } else {
            return  super.getAsText();
        }
    }
}
