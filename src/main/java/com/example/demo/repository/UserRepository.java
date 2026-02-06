package com.example.demo.repository;

import com.example.demo.model.entity.UserEntity;

import java.util.List;

public interface UserRepository {

    public UserEntity getById(Integer id);
    public List<UserEntity> findAll();
    public Integer add(UserEntity userEntity);
    public Integer update(UserEntity userEntity);
    public Integer remove(Integer id);
}
