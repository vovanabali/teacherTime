package com.vitgtk.teacherTime.service.user;

import com.vitgtk.teacherTime.dao.RoleDao;
import com.vitgtk.teacherTime.dao.UserDao;
import com.vitgtk.teacherTime.domain.Group;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println();
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void remuveUser(User user) {
        userDao.remuveUser(user);
    }

    @Override
    public List<User> getAllUsersByGroup(Group group) {
        return userDao.getAllUsersByGroup(group);
    }
}
