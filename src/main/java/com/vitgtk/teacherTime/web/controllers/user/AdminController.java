package com.vitgtk.teacherTime.web.controllers.user;

import com.vitgtk.teacherTime.domain.*;
import com.vitgtk.teacherTime.service.lesson.GroupService;
import com.vitgtk.teacherTime.service.lesson.LessonService;
import com.vitgtk.teacherTime.service.role.RoleService;
import com.vitgtk.teacherTime.service.teacher.TeacherService;
import com.vitgtk.teacherTime.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/teachingload")
    public String settings() {
        return "teachingload";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/teachers")
    @ResponseBody
    public List<Teacher> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/teacher")
    @ResponseBody
    public Teacher getTeacher(@RequestParam("id") int id) {
        return teacherService.getTeatcherById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/lessons")
    @ResponseBody
    public List<Lesson> getLessons() {
        return lessonService.getAllLessons();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/group")
    @ResponseBody
    public List<Group> getGroup() {
        return groupService.getAllGroups();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/roles")
    @ResponseBody
    public List<Role> getRoles() {
        return roleService.getAllRolse();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/users")
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
