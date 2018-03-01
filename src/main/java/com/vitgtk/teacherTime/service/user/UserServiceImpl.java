package com.vitgtk.teacherTime.service.user;

import com.vitgtk.teacherTime.dao.LessonTimeDao;
import com.vitgtk.teacherTime.dao.RoleDao;
import com.vitgtk.teacherTime.dao.TeacherLessonDao;
import com.vitgtk.teacherTime.dao.UserDao;
import com.vitgtk.teacherTime.domain.Group;
import com.vitgtk.teacherTime.domain.LessonTime;
import com.vitgtk.teacherTime.domain.Teacher;
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
    @Autowired
    private TeacherLessonDao teacherLessonDao;
    @Autowired
    private LessonTimeDao lessonTimeDao;

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
    public boolean remuveUser(User user) {
        User userTemp = userDao.getUserById(user.getId());
        if (userTemp != null) {
            Teacher teacher = new Teacher();
            if (teacher.getLessons() != null) {
                teacher.getLessons().forEach(teachersLesson -> teachersLesson.getExactTime().forEach(lessonTime -> {
                    lessonTimeDao.remuveLessonTime(lessonTime);
                }));
                teacherLessonDao.deleteAllTeacherLessons(user);
            }
            roleDao.deleteAllRolesUser(user.getId());
            userDao.remuveUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getAllUsersByGroup(Group group) {
        return userDao.getAllUsersByGroup(group);
    }
}
