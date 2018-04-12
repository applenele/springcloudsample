package com.smallcode.springcloud.clinic.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-uc")
public interface UcClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    String getUser(@RequestParam(value = "id") int id);
}
