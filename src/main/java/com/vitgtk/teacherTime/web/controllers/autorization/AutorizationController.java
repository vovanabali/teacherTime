package com.vitgtk.teacherTime.web.controllers.autorization;

import com.vitgtk.teacherTime.domain.Teacher;
import com.vitgtk.teacherTime.domain.User;
import com.vitgtk.teacherTime.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class AutorizationController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET, value = "/teacherInJson")
    @ResponseBody
    public List<Teacher> teacherInJson() {
        List<Teacher> teacher = teacherService.getAllTeachers();
        System.out.println();
        return teacher;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:authorization";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", true);
        }
        if (logout != null) {
            model.addAttribute("msg", true);
        }
        return "authorization";
    }
}
