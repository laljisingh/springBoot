package com.laljisingh.instagram.controller;

import com.laljisingh.instagram.model.User;
import com.laljisingh.instagram.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/user")
    public ResponseEntity saveUser(@RequestBody String userData) {

        User user = setUser(userData);

        int userId = service.saveUser(user);
        return new ResponseEntity("user saved with id- " +userId, HttpStatus.CREATED);

    }

    private User setUser(String userData) {

        JSONObject jsonObject = new JSONObject(userData);
        User user = new User();

        user.setAge(jsonObject.getInt("age"));
        user.setEmail(jsonObject.getString("email"));
        user.setFirstName(jsonObject.getString("firstName"));
        user.setLastName(jsonObject.getString("lastName"));
        user.setPhoneNumber(jsonObject.getString("number"));

        return user;

    }
}
