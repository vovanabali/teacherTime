package com.vitgtk.teacherTime.service.lesson;

import com.vitgtk.teacherTime.domain.Group;
import com.vitgtk.teacherTime.domain.User;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    void addGroup(Group group);

    void remuveGroup(Group group);

    Group getGroup(User user);
}
