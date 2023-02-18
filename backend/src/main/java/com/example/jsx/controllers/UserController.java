package com.example.jsx.controllers;


import com.example.jsx.entities.User;
import com.example.jsx.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return UserService.getAllUsers();
    }

    @PostMapping
    public User creteUser(@RequestBody User newUser) {
        return UserService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        return UserService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
        return UserService.updateOneUser(userId, newUser);

    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        UserService.deleteById(userId);
    }
}


