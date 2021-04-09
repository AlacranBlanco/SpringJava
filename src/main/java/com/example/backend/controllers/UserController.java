package com.example.backend.controllers;
import com.example.backend.models.requests.UserDetailRequestModel;
import com.example.backend.models.responses.UserRest;
import com.example.backend.services.UserServiceInterface;
import com.example.backend.shared.dto.UserDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // Localhost:8080/users
public class UserController {
    
    @Autowired
    UserServiceInterface userService;

    @GetMapping
    public String getUser() {
        return "get user details";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) {
       
        UserRest userToReturn = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, userToReturn);
        return userToReturn;
    }
}
