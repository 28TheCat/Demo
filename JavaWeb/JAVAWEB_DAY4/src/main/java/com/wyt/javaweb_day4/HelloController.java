package com.wyt.javaweb_day4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("hello world"+ name);
        return "hello world "+ name;
    }
}
