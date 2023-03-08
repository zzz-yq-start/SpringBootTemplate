package com.example.basictemplate.mapper;

import com.example.basictemplate.model.user;


public interface userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer id);

    user selectByCondition(String username);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}