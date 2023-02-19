package com.laljisingh.ecommerce.dao;

import com.laljisingh.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
