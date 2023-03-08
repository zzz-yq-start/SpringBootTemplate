package com.example.basictemplate.server;

import com.example.basictemplate.model.user;

import java.util.List;

public interface UserServer {
    public user queryAuthorityToUser(String username);
}
