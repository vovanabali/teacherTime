package com.vitgtk.teacherTime.dao;

import com.vitgtk.teacherTime.domain.Group;
import com.vitgtk.teacherTime.domain.Lesson;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUserById(int id);

    User getUserByLogin(String login);

    void addUser(User user);

    void remuveUser(User user);

    List<User> getAllUsersByGroup(Group group);

    List<User> getAllUsers();
}
