package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-boot-demo
 * @description: 用户处理
 * @author: liuhang
 * @create: 2019-08-02 12:23
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public Map getUserName( ){

        HashMap map = new HashMap<>();
        map.put("user", new User());
        return map;
    }
}
