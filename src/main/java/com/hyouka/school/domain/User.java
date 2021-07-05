package com.hyouka.school.domain;


import com.hyouka.school.utils.UUID;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@ToString(exclude = {"createtime"})
@Data
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    @Id
    @KeySql(genId = UUID.class)
    private String id;
    private Integer age;
    private String sex;
    private String name;
    private String account;
    private String password;
    private String createtime;
    private String authority;

}
