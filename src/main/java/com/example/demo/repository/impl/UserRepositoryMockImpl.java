package com.example.demo.repository.impl;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryMockImpl implements UserRepository {

    private Map<Integer, UserEntity> userEntityMap = null;
    private Integer id = 1;

    public UserRepositoryMockImpl() {

        UserEntity userEntity1 = UserEntity.builder()
                .id(id++)
                .name("Heidie Waplinton")
                .username("hwaplinton0")
                .email("hwaplinton0@nbcnews.com")
                .phone("920-478-6978")
                .website("hubpages.com")
                .build();

        UserEntity userEntity2 = UserEntity.builder()
                .id(id++)
                .name("Heidie Waplinton")
                .username("hwaplinton0")
                .email("hwaplinton0@nbcnews.com")
                .phone("920-478-6978")
                .website("hubpages.com")
                .build();

        UserEntity userEntity3 = UserEntity.builder()
                .id(id++)
                .name("Heidie Waplinton")
                .username("hwaplinton0")
                .email("hwaplinton0@nbcnews.com")
                .phone("920-478-6978")
                .website("hubpages.com")
                .build();

        userEntityMap = new HashMap<>();
        userEntityMap.put(userEntity1.getId(), userEntity1);
        userEntityMap.put(userEntity2.getId(), userEntity2);
        userEntityMap.put(userEntity3.getId(), userEntity3);
    }

    @Override
    public UserEntity getById(Integer id) {
        return userEntityMap.get(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return new ArrayList<UserEntity>(userEntityMap.values());
    }

    @Override
    public Integer add(UserEntity userEntity) {
        userEntity.setId(id++);
        userEntityMap.put(userEntity.getId(), userEntity);
        return userEntity.getId();
    }

    @Override
    public Integer update(UserEntity userEntity) {
        userEntityMap.put(userEntity.getId(), userEntity);
        return userEntity.getId();
    }

    @Override
    public Integer remove(Integer id) {
        userEntityMap.remove(id);
        return id;
    }

}
