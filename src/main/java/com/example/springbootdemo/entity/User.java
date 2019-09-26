package com.example.springbootdemo.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;

/**
 * @program: spring-boot-demo
 * @description: 用户
 * @author: liuhang
 * @create: 2019-08-02 12:22
 **/
@Data
public class User {

    private String userName;
    private String password;
    private int age;



}
