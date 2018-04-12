package com.smallcode.springcloudsample.service.provider.uc.controller;


import com.smallcode.commons.util.JsonUtil;
import com.smallcode.springcloudsample.service.provider.uc.dao.UserRepository;
import com.smallcode.springcloudsample.service.provider.uc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/hi")
    public String Hi(String name) {
        return "hello: " + name;
    }

    @GetMapping(value = "/getUser")
    public String getUser(int id) {
        User user = userRepository.findOne(id);
        return JsonUtil.toString(user);
    }
}
