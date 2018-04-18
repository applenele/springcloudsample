package com.smallcode.springcloudsample.zipkin.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApllication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApllication.class,args);
    }
}
