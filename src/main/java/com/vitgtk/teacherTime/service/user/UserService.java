package com.vitgtk.teacherTime.service.user;

import com.vitgtk.teacherTime.domain.Group;
import com.vitgtk.teacherTime.domain.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    List<User> getAllUsers();

    User getUserByLogin(String login);

    void addUser(User user);

    void remuveUser(User user);

    List<User> getAllUsersByGroup(Group group);
}
