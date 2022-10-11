package com.blog.api.controllers;

import com.blog.api.entities.User;
import com.blog.api.payloads.UserDto;
import com.blog.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer userId){
       UserDto updatedUser=  this.userService.updateUser(userDto,userId);
       return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{userId")
    public ResponseEntity<UserDto> deletedUser(@PathVariable("userId") Integer userId){
        this.userService.deleteUser(userId);

        return new ResponseEntity(Map.of("message","user successfully deleted"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
