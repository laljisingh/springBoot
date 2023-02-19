package com.laljisingh.ecommerce.controller;

import com.laljisingh.ecommerce.model.User;
import com.laljisingh.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("add-user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("get-userBy-id/{Id}")
    public Optional<User> getUserById(@PathVariable int Id){
        return userService.getUserById(Id);
    }
}
