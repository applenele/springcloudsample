package com.smallcode.springcloud.clinic.service;


import com.smallcode.springcloud.clinic.domain.UserEntity;
import com.smallcode.springcloud.clinic.mapper.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {

    @Autowired
    private User1Mapper user1Mapper;

    public List<UserEntity> getUsers() {
        List<UserEntity> users = user1Mapper.getAll();
        return users;
    }

    //    @Transactional(value="test1TransactionManager",rollbackFor = Exception.class,timeout=36000)  //说明针对Exception异常也进行回滚，如果不标注，则Spring 默认只有抛出 RuntimeException才会回滚事务
    public void updateTransactional(UserEntity user) {
        user1Mapper.insert(user);
    }


}
