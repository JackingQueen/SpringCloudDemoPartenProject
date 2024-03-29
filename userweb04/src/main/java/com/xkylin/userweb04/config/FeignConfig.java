package com.xkylin.userweb04.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level getFeignlogger(){
        return Logger.Level.FULL;
    }
}
