package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public boolean register(String username, String password) {
        return userService.register(username, password);
    }

    public User login(String username, String password) {
        return userService.login(username, password);
    }
}