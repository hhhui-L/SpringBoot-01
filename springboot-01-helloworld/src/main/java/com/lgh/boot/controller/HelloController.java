package com.lgh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller

@RestController
public class HelloController {
    /**
     * 1. @RequestMapping：映射请求，希望浏览器发送hello请求
     * 2. 发送请求后处理，给浏览器返回一串话
     * 3. 请求处理，以字符串的形式写给浏览器，所以ResponseBody
     */
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello,Spring boot 2!"+"你好";
    }
}
