package com.hyouka.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogonController {

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "login/index")
    public String login() {
        return "login/index";
    }
}
