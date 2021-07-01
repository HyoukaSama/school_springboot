package com.hyouka.school.domain;


import com.hyouka.school.utils.UUID;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    @Id
    @KeySql(genId= UUID.class)
    private String id;
    private Integer age;
    private String sex;
    private String name;
    private String account;
    private String password;

}
