package com.onlineapp.controller;

import com.onlineapp.onlineapp.models.User;

//package com.example.controller;

import io.javalin.http.Context;
import service.UserService;


public class LoginController {
    private final UserService userService = new UserService();

    public void login(Context ctx) {
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");
     User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            ctx.result("Login successful");
        } else {
            ctx.result("Invalid username or password");
        }
    }
}
