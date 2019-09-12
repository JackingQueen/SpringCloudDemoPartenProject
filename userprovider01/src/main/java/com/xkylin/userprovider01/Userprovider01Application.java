package com.xkylin.userprovider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Userprovider01Application {

    public static void main(String[] args) {
        SpringApplication.run(Userprovider01Application.class, args);
    }

}
