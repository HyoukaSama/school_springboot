package com.hyouka.school.utils;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import tk.mybatis.mapper.genid.GenId;

public class UUID implements GenId<String> {
    @Override
    public String genId(String s, String s1) {
        return java.util.UUID.randomUUID().toString().replace("-","");
    }
}
