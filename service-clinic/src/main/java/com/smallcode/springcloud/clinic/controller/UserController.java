package com.smallcode.springcloud.clinic.controller;

import com.smallcode.springcloud.clinic.bean.UserSexEnum;
import com.smallcode.springcloud.clinic.domain.UserEntity;
import com.smallcode.springcloud.clinic.service.UcClient;
import com.smallcode.springcloud.clinic.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private UcClient ucClient;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users = user1Service.getUsers();
        return users;
    }

    //测试
    @RequestMapping(value = "update1")
    public String updateTransactional(@RequestParam(value = "id") Long id,
                                      @RequestParam(value = "user_id") Long user_id,
                                      @RequestParam(value = "order_id") Long order_id,
                                      @RequestParam(value = "nickName") String nickName,
                                      @RequestParam(value = "passWord") String passWord,
                                      @RequestParam(value = "userName") String userName
    ) {
        UserEntity user2 = new UserEntity();
        user2.setId(id);
        user2.setUser_id(user_id);
        user2.setOrder_id(order_id);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        user2.setUserSex(UserSexEnum.WOMAN);
        user1Service.updateTransactional(user2);
        return "test";
    }

    @GetMapping(value = "/getUser")
    public String getUser(int id) {
        return ucClient.getUser(id);
    }
}

