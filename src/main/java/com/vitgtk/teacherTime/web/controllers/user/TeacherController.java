package com.vitgtk.teacherTime.web.controllers.user;

import com.vitgtk.teacherTime.domain.Teacher;
import com.vitgtk.teacherTime.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.invoke.empty.Empty;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String mainPage() {
        return "main";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/teachingload")
    public String settings() {
        return "teachingload";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/autchInfo")
    @ResponseBody
    public Teacher getTeachers() {
        Teacher teacher = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            teacher = teacherService.getTeacherByLogin(authentication.getName());
            teacher.getTeacher().setPassword("");
        }
        return teacher;
    }
}
