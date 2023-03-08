package com.example.basictemplate.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础Mapper
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
