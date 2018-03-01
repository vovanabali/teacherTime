package com.vitgtk.teacherTime.web.controllers.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller("/")
public class UserController {
    @RequestMapping(value = "/teachingload", method = RequestMethod.GET)
    public String getMainPage() {
        return "teachingload";
    }
}
