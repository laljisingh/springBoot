package com.laljisingh.ecommerce.service;

import com.laljisingh.ecommerce.dao.UserRepository;
import com.laljisingh.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    public String addUser(User newUser) {
        repository.save(newUser);
        return "USer Saved";
    }

    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }
}
