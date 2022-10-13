package com.blog.api.services;

import com.blog.api.entities.User;
import com.blog.api.payloads.ResourceNotFoundExceptiuon;
import com.blog.api.payloads.UserDto;
import com.blog.api.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
        //        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user  = this.userRepo.findById(userId).orElseThrow();
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        System.out.println(userDto.getEmail());
        return this.userToDto(user);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExceptiuon("User","id",userId));
        return this.userToDto(user);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow();
        this.userRepo.delete(user);
    }



    public User dtoToUser(UserDto userDto){
        User user =this.modelMapper.map(userDto,User.class);
        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user,UserDto.class);

        return userDto;
    }
}
