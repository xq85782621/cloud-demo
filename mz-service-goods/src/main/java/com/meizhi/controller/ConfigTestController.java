package com.meizhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来测试从配置中心获取配置
 */
@RestController
@RequestMapping("/config")
@RefreshScope //加这个注解才能获得刷新后的配置(即使动态修改了端口,在这里的port被改变了,但是项目的端口依然不会改变)
public class ConfigTestController {

    @Value("${myname}")
    private String name;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/name")
    public String getName(){
        return name;
    }

    @RequestMapping("/port")
    public String getPort(){ return  port;}


}
