package com.hyouka.school.controller;


import com.hyouka.school.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/getAllUser")
    @ResponseBody
    public String getAllUser() {
        return userService.getAllUser().toString();
    }

}
