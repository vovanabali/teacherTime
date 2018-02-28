package com.vitgtk.teacherTime.dao;

import com.vitgtk.teacherTime.domain.Group;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDao {
    List<Group> getAllGroups();

    void addGroup(Group group);

    void remuveGroup(Group group);

    Group getGroup(User user);
}
