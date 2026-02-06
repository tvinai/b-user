package com.example.demo.mapper;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.request.UserRequest;

public class UserEntityMapper {

    private UserEntityMapper() {

    }

    public static UserEntity from(UserRequest userRequest) {

        UserEntity userEntity = new UserEntity();

        userEntity.setName(userRequest.getName());
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPhone(userRequest.getPhone());
        userEntity.setWebsite(userRequest.getWebsite());

        return userEntity;
    }

}
