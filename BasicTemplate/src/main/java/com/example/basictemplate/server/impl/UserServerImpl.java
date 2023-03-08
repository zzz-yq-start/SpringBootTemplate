package com.example.basictemplate.server.impl;

import com.example.basictemplate.mapper.userMapper;
import com.example.basictemplate.model.user;
import com.example.basictemplate.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {
    @Autowired
    public userMapper UserMapper;
    @Override
    public user queryAuthorityToUser(String username) {
        user User=UserMapper.selectByCondition(username);
        return User;
    }
}
