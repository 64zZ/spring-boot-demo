package com.example.springbootdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: liuhang
 * @create: 2019-08-02 13:42
 **/
@Data
public class Teacher {
    private String name;
    private List<User> lists;
}
