package com.xkylin.userprovider02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Userprovider02Application {

    public static void main(String[] args) {
        SpringApplication.run(Userprovider02Application.class, args);
    }

}
