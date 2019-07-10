package com.meizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient //eureka
@EnableFeignClients // 开启Feign功能
@MapperScan("com.meizhi.mapper")
@EnableCircuitBreaker //hystrix
public class UserApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserApplication.class, args);
    }
}
