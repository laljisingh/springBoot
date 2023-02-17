package com.lalji.userManage.controller;

import com.lalji.userManage.model.User;
import com.lalji.userManage.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("get-all-user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("get-user-by-id/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }
    @PostMapping("add-User")
    public ResponseEntity<User> addUser(@Valid @RequestBody User newUser){
        if(userService.addUser(newUser)){
            return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(newUser, HttpStatus.BAD_GATEWAY);
    }

    @DeleteMapping("delete-user/{id}")
    public String deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }

    @PutMapping("update-User/{id}")
    public String updateUser(@RequestBody User newUser,@PathVariable String id){
        return userService.updateUser(newUser, id);
    }

}
