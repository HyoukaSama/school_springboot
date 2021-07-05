package com.hyouka.school.service;

import com.hyouka.school.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;


    @Test
    public void TestAddUser() {
        User user = new User();

        user.setAccount("cs1");
        user.setName("cs1");
        user.setAge(11);
        user.setPassword("cs1");
        user.setSex("M");
        System.out.println(userService.saveUser(user));
    }
}
