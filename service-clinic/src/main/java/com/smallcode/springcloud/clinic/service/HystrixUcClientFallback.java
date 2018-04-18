package com.smallcode.springcloud.clinic.service;


import org.springframework.stereotype.Component;

@Component
public class HystrixUcClientFallback implements UcClient {

    @Override
    public String getUser(int id) {
        return "test";
    }
}
