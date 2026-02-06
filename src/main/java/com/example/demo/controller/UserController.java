package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserEntityMapper;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.request.UserRequest;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Integer userId) {

        UserEntity userEntity = userRepository.getById(userId);
        if (userEntity == null) {
            throw new UserNotFoundException("78", "User not found");
        }

        return userRepository.getById(userId);
    }

    @PostMapping
    public Integer save(@RequestBody UserRequest userRequest) {
        UserEntity userEntity = UserEntityMapper.from(userRequest);
        return userRepository.add(userEntity);
    }

    @PutMapping("/{userId}")
    public Integer update(@PathVariable Integer userId,
                          @RequestBody UserRequest userRequest) {

        UserEntity userEntity = userRepository.getById(userId);
        if (userEntity == null) {
            throw new UserNotFoundException("78", "User not found");
        }

        UserEntity newUserEntity = UserEntityMapper.from(userRequest);
        newUserEntity.setId(userId);
        return userRepository.update(newUserEntity);

    }

    @DeleteMapping("/{userId}")
    public Integer remove(@PathVariable Integer userId) {

        UserEntity userEntity = userRepository.getById(userId);
        if (userEntity == null) {
            throw new UserNotFoundException("78", "User not found");
        }

        return userRepository.remove(userId);
    }

}
