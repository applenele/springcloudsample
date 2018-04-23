package com.smallcode.springcloudsample.service.provider.uc.controller;


import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
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

    @GetMapping(value = "/getProperty")
    public String getProperty(String nameSpace, String key) {
        //Config config = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
        Config config = ConfigService.getConfig(nameSpace);
        String val = config.getProperty(key, "default");
        return val;
    }
}
