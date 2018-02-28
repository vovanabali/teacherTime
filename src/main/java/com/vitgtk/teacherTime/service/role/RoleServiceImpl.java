package com.vitgtk.teacherTime.service.role;

import com.vitgtk.teacherTime.dao.RoleDao;
import com.vitgtk.teacherTime.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRolesByLogin(String login) {
        return roleDao.getRolesByLogin(login);
    }

    @Override
    public List<Role> getRolesById(Integer id) {
        return roleDao.getRolesById(id);
    }

    @Override
    public List<Role> getAllRolse() {
        return roleDao.getAllRolse();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public void addRole(String role) {
        roleDao.addRole(role);
    }

    @Override
    public void setRoleToUser(Integer id, Integer roleId) {
        roleDao.setRoleToUser(id, roleId);
    }

    @Override
    public void remuveRoleUser(Integer userId, Role role) {
        roleDao.remuveRoleUser(userId, role);
    }

    @Override
    public void deleteAllRolesUser(Integer id) {
        roleDao.deleteAllRolesUser(id);
    }
}
