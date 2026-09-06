package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Value("${server.port}")
    private String serverPort;

    @PostMapping
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUser(id);
    }

    @GetMapping("/instance")
    public String getInstance() {
        return "Response from User Service instance running on port: " + serverPort;
    }

}
