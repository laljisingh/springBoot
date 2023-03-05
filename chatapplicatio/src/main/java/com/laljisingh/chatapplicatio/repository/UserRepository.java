package com.laljisingh.chatapplicatio.repository;

import com.laljisingh.chatapplicatio.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
