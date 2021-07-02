package com.hyouka.school.service;

import com.hyouka.school.domain.User;
import com.hyouka.school.utils.StudentConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void TestTranscational() {
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setAccount("trans");
        user1.setName("tr1");
        userList.add(user1);

        User user2 = new User();
        user2.setAccount("trans");
        user2.setName("tr2");
        userList.add(user2);

        System.out.println(userService.addUsers(userList));

    }

    @Test
    public void TestTrans3() {
        User user = new User();
        user.setId("1ba8f1f22a33442605d311b70c145");
        user.setAge(15);
        user.setAccount("tr");
//        userService.test3(user);
        userService.test4(user);


    }



}
