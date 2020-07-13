package com.tw.appsec101.controller;

import com.tw.appsec101.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password)
            throws Exception {
        final UserRepo.LoginResult loginResult = userRepo.login(username, password);

        if (loginResult.success) {
            return "Welcome " + loginResult.username + "!";
        } else {
            return "Sorry, please check your username and password combination.";
        }
    }
}
