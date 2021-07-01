package com.hyouka.school.service;


import com.hyouka.school.domain.User;
import com.hyouka.school.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    public User getOneUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
