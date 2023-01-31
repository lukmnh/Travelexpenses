package com.example.demo.services;

import com.example.demo.dto.Login;
import com.example.demo.models.User;

public interface UserService {
    public Boolean save(User user);

    // public User findPassword(String password);

    public Object login(Login login);

    public Boolean changePassword(String password, Integer id);

}
