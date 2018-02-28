package com.vitgtk.teacherTime.dao;

import com.vitgtk.teacherTime.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    List<Role> getRolesByLogin(String login);

    List<Role> getRolesById(Integer id);

    List<Role> getAllRolse();

    Role getRoleById(Integer id);

    void addRole(String role);

    void setRoleToUser(@Param("id") Integer id, @Param("roleId") Integer roleId);

    void remuveRoleUser(@Param("id") Integer userId, @Param("role") Role role);

    void deleteAllRolesUser(Integer id);
}
