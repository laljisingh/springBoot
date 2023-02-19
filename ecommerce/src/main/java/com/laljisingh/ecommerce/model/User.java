package com.laljisingh.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    @Column(name = "user_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private  String password;
    @Column(name = "user_phoneNumber")
    private  String phoneNumer;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public User() {
    }

    public User(Integer userId, String name, String email, String password, String phoneNumer) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumer = phoneNumer;
    }
}
