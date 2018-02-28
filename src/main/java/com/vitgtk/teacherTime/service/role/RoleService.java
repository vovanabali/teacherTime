package com.vitgtk.teacherTime.service.role;

import com.vitgtk.teacherTime.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    List<Role> getRolesByLogin(String login);

    List<Role> getRolesById(Integer id);

    List<Role> getAllRolse();

    Role getRoleById(Integer id);

    void addRole(String role);

    void setRoleToUser(@Param("id") Integer id, @Param("roleId") Integer roleId);

    void remuveRoleUser(@Param("id") Integer userId, @Param("role") Role role);

    void deleteAllRolesUser(Integer id);

}
