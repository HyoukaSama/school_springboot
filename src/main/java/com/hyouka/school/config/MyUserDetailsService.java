package com.hyouka.school.config;

import com.hyouka.school.domain.User;
import com.hyouka.school.mapper.UserMapper;
import com.hyouka.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User user = new User();
        user.setAccount(account);
        user = userMapper.selectOne(user);

        if (user == null) {
            throw new UsernameNotFoundException("不存在该用户");
        }


        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user.getAuthority() != null) {
            authorities.add(new SimpleGrantedAuthority(user.getAuthority()));

        }


        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        return userDetails;

    }
}
