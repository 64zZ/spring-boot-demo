package com.example.staticTest;

import org.junit.Test;

/**
 * @program: spring-boot-demo
 * @description: 静态资源测试子类
 * @author: liuhang
 * @create: 2019-09-05 11:23
 **/
public class Child extends Father implements Person {



    public static void main(String[] args) {
        System.out.println(value);
        Father.test();
        System.out.println(value);

    }
}
