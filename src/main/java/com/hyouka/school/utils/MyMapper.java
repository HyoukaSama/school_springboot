package com.hyouka.school.utils;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;

public interface MyMapper<T> extends BaseMapper<T>, MySqlMapper<T>, InsertMapper<T> {
}
