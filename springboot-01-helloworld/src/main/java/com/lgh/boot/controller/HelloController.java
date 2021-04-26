package com.lgh.boot.controller;

import com.lgh.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller

// JRebel 重加载
@Slf4j //简化日志开发，日志属性，自动给类注入log属性
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    /**
     * 1. @RequestMapping：映射请求，希望浏览器发送hello请求
     * 2. 发送请求后处理，给浏览器返回一串话
     * 3. 请求处理，以字符串的形式写给浏览器，所以ResponseBody
     */
    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){

        log.info("请求进来了.......");
        return "Hello,Spring boot 2!"+"你好:"+name;
    }
}
