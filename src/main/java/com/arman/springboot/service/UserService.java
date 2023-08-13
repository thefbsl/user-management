package com.arman.springboot.service;

import com.arman.springboot.dto.UserDto;
import com.arman.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);

}
