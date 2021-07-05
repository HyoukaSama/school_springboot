package com.hyouka.school.service;


import com.hyouka.school.domain.User;
import com.hyouka.school.mapper.UserMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    public User getOneUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateUser(User user) {
        if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int saveUser(User user) {
        if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userMapper.insert(user);
    }

    public void addUsers1(User user) {
        System.out.println("事务测试");
        userMapper.insert(user);
    }

    @Transactional
    public boolean addUsers(List<User> userList) {
        boolean result = true;
        try {
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
//                userMapper.insert(user);
                addUsers1(user);
            }
        } catch (Exception e) {
            System.out.println("发生异常，手动回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result = false;
            e.printStackTrace();
        }
        return result;

    }

    @Transactional
    public boolean test3(User user) {

        /*
         * 子方法出现异常进行回滚
         */
        try {
            System.out.println("查询的数据1:" + userMapper.selectByPrimaryKey(user.getId()));
            deal1(user);
            deal2(user);
            deal3(user);
        } catch (Exception e) {
            System.out.println("发生异常,进行手动回滚！");
            // 手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public void deal1(User user) throws SQLException {
        userMapper.insert(user);
        System.out.println("查询的数据2:" + userMapper.selectByPrimaryKey(user.getId()));
    }

    public void deal2(User user) throws SQLException {
        if (user.getAge() < 20) {
            //SQL异常
            userMapper.insert(user);
        } else {
            user.setAge(21);
            userMapper.updateByPrimaryKeySelective(user);
            System.out.println("查询的数据3:" + userMapper.selectByPrimaryKey(user.getId()));
        }
    }

    @Transactional(rollbackFor = SQLException.class)
    public void deal3(User user) {
        if (user.getAge() > 20) {
            //SQL异常
            userMapper.insert(user);
        }

    }



   /* @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    public boolean test4(User user) {
        *//*
     * 手动进行事物控制
     *//*
        TransactionStatus transactionStatus = null;
        boolean isCommit = false;
        try {
            transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            System.out.println("查询的数据1:" + userMapper.selectByPrimaryKey(user.getId()));
            // 进行新增/修改
            userMapper.insert(user);
            System.out.println("查询的数据2:" + userMapper.selectByPrimaryKey(user.getId()));
            if (user.getAge() < 20) {
                user.setAge(user.getAge() + 2);
                userMapper.updateByPrimaryKeySelective(user);
                System.out.println("查询的数据3:" + userMapper.selectByPrimaryKey(user.getId()));
            } else {
                throw new Exception("模拟一个异常!");
            }
            //手动提交
            dataSourceTransactionManager.commit(transactionStatus);
            isCommit = true;
            System.out.println("手动提交事物成功!");
            throw new Exception("模拟第二个异常!");

        } catch (Exception e) {
            //如果未提交就进行回滚
            if (!isCommit) {
                System.out.println("发生异常,进行手动回滚！");
                //手动回滚事物
                dataSourceTransactionManager.rollback(transactionStatus);
            }
            e.printStackTrace();
        }
        return false;
    }*/
}
