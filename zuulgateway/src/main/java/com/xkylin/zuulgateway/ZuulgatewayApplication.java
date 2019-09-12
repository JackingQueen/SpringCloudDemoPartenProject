package com.xkylin.zuulgateway;

import com.xkylin.zuulgateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
// 包含了 @SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
@SpringCloudApplication
public class ZuulgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulgatewayApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
