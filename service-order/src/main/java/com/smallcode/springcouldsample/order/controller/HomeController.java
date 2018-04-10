package com.smallcode.springcouldsample.order.controller;


import com.smallcode.springcouldsample.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/sayHi")
    public String orderHi(String name) {
        return orderService.hiService(name);
    }

    @GetMapping(value = "/getUser")
    public String getUser(int id) {
        return orderService.getUser(id);
    }
}
