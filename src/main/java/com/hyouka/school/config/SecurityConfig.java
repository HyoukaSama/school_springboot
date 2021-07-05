package com.hyouka.school.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")// 自定义登录页面路径
                .loginProcessingUrl("/authentication/form")// 自定义页面的登录路径，注意要与登录页面的action值一致，<form action="/authentication/form" method="post">
                // 登录失败Url
                .failureUrl("/login/error")
                .and()
                .logout().permitAll()
                .and()
                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html").permitAll()// 设置所有人都可以访问登录页面
                .anyRequest().authenticated()  // 除了以上的请求外都需要身份验证
        ;
        http.csrf().disable();

    }


}
