package com.hyouka.school.redis;


import com.alibaba.fastjson.JSONObject;
import com.hyouka.school.domain.User;
import com.hyouka.school.service.UserService;
import com.hyouka.school.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserService userService;


    @Test
    public void set() {
        redisUtils.set("name", "Mr Bao");
    }

    @Test
    public void get() {
        System.out.println(redisUtils.get("name"));
    }


    @Test
    public void hash() {
        String userid = "65bb140c296c48019f526717451c4d21";
        String result = redisUtils.hget("user", userid);

        if (result == null) {
            System.out.println("未查询到缓存");

            result = JSONObject.toJSONString(userService.getOneUser(userid));
            redisUtils.hset("user", userid, result);
            System.out.println("插入缓存");
        } else {
            System.out.println("读取缓存");
            throw new RuntimeException();
        }
        System.out.println(result);
    }
}
