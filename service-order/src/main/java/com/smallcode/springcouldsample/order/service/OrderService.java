package com.smallcode.springcouldsample.order.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "defaultFallback")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-ZUUL-GATEWAY/uc/hi?name=" + name, String.class);
    }

    public String getUser(int id) {
        return restTemplate.getForObject("http://SERVICE-UC/getUser?id=" + id, String.class);
    }

    public String hiCallback(String name) {
        return "test";
    }

    public String defaultFallback(){
        return "dd";
    }

}
