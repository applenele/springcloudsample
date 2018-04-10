package com.smallcode.springcouldsample.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-UC/hi?name=" + name, String.class);
    }

    public String getUser(int id){
        return restTemplate.getForObject("http://SERVICE-UC/getUser?id=" + id, String.class);
    }
}
