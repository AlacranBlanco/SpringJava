package com.example.backend.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long id;
    private String userId;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String encrypPassword;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncrypPassword() {
        return this.encrypPassword;
    }

    public void setEncrypPassword(String encrypPassword) {
        this.encrypPassword = encrypPassword;
    }

    
}