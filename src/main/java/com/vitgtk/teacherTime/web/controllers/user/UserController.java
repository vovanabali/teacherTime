package com.vitgtk.teacherTime.web.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/")
public class UserController {
    @RequestMapping(value = "/teachingload", method = RequestMethod.GET)
    public String getMainPage() {
        return "teachingload";
    }
}
