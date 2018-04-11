package com.smallcode.springcloud.clinic.mapper;

import com.smallcode.springcloud.clinic.domain.UserEntity;

import java.util.List;

public interface User1Mapper {

    List<UserEntity> getAll();

    void update(UserEntity user);

    void insert(UserEntity user);
}
