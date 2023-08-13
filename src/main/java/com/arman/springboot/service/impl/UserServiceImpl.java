package com.arman.springboot.service.impl;

import com.arman.springboot.dto.UserDto;
import com.arman.springboot.entity.User;
import com.arman.springboot.exception.EmailAlreadyExistsException;
import com.arman.springboot.exception.ResourceNotFoundException;
import com.arman.springboot.mapper.AutoUserMapper;
import com.arman.springboot.mapper.UserMapper;
import com.arman.springboot.repository.UserRepository;
import com.arman.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent())
            throw new EmailAlreadyExistsException("User with this email already exists");
        // User user = UserMapper.mapToUser(userDto);
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        // UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        return AutoUserMapper.MAPPER.mapToUserDto(user);
        // return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(AutoUserMapper.MAPPER::mapToUserDto).collect(Collectors.toList());
        // return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userDto.getId())
        );
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
        // return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        userRepository.deleteById(userId);
    }
}
