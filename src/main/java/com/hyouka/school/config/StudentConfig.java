package com.hyouka.school.config;

import com.hyouka.school.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean(name = "student", initMethod = "init", destroyMethod = "destory")
    public Student getStudent() {
        return new Student();
    }

}
