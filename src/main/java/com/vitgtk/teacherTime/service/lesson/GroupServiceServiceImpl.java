package com.vitgtk.teacherTime.service.lesson;

import com.vitgtk.teacherTime.dao.GroupDao;
import com.vitgtk.teacherTime.domain.Group;
import com.vitgtk.teacherTime.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }

    @Override
    public void remuveGroup(Group group) {
        groupDao.remuveGroup(group);
    }

    @Override
    public Group getGroup(User user) {
        return groupDao.getGroup(user);
    }
}
