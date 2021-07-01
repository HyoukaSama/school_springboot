package com.hyouka.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogonController {

    @GetMapping(value = "index")
    public String index(){
        return "index";
    }


    @GetMapping(value = "login")
    public String login(){
        return "login";
    }
}
