package com.userlogin.userlogin.service.user.api;

import com.userlogin.userlogin.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User save(User user);
}
