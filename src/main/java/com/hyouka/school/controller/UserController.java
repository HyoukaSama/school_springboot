package com.hyouka.school.controller;


import com.hyouka.school.domain.User;
import com.hyouka.school.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/getAllUser")
    @ResponseBody
    public String getAllUser() {
        return userService.getAllUser().toString();
    }


    @RequestMapping(value = "/saveUser")
    @ResponseBody
    public String saveUser(User user) throws SQLException {

        int result = userService.saveUser(user);

        return result == 1 ? "插入成功" : "插入失败";
    }

    @GetMapping(value = "/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String admin() {
        return "admin";
    }

    @GetMapping(value = "/helloUser")
    @PreAuthorize("hasAnyRole('admin','user')")
    @ResponseBody
    public String user() {
        return "Hello,user";
    }
}
