package com.vitgtk.teacherTime.web.controllers.user;

import com.vitgtk.teacherTime.dao.LessonTimeDao;
import com.vitgtk.teacherTime.domain.*;
import com.vitgtk.teacherTime.service.lesson.GroupService;
import com.vitgtk.teacherTime.service.lesson.LessonService;
import com.vitgtk.teacherTime.service.lesson.LessonTimeService;
import com.vitgtk.teacherTime.service.role.RoleService;
import com.vitgtk.teacherTime.service.security.UserPropertiEditor;
import com.vitgtk.teacherTime.service.teacher.TeacherService;
import com.vitgtk.teacherTime.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private LessonTimeService lessonTimeService;

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

    @RequestMapping(method = RequestMethod.GET, value = "/json/addUser")
    @ResponseBody
    public Boolean addNewUser(@RequestParam Teacher teacher) {
        if (teacher.getTeacher() != null) {
            userService.addUser(teacher.getTeacher());
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/updateTeacherLessonTime")
    @ResponseBody
    public Boolean updateTeacherLessonTime(@RequestParam Teacher teacher) {
        if (teacher.getTeacher() != null) {
            teacherService.updateTeacherExTime(teacher);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/updateTeacherInfo")
    @ResponseBody
    public Boolean updateTeacherInfo(@RequestParam Teacher teacher) {
        if (teacher.getTeacher() != null) {
            teacherService.updateTeacherExTime(teacher);
            return true;
        } else {
            return false;
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestParam int id) {
        User user = new User();
        user.setId(id);
        return userService.remuveUser(user);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Teacher.class, new UserPropertiEditor());
    }
}
