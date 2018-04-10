package com.smallcode.springcloudsample.service.provider.uc.service.impl;


import com.smallcode.springcloudsample.service.provider.uc.dao.UserRepository;
import com.smallcode.springcloudsample.service.provider.uc.domain.User;
import com.smallcode.springcloudsample.service.provider.uc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
