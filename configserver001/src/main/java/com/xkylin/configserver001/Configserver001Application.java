package com.xkylin.configserver001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class Configserver001Application {

    public static void main(String[] args) {
        SpringApplication.run(Configserver001Application.class, args);
    }

}
