package com.blog.api.controllers;

import com.blog.api.payloads.UserDto;
import com.blog.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserControllers {


    @Autowired
    private UserService userService;

    //POST MAPPING
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userq){
        UserDto userDto = this.userService.createUser(userq);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    //PUT mapping

}
