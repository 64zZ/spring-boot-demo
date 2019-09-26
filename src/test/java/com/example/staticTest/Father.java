package com.example.staticTest;

/**
 * @program: spring-boot-demo
 * @description: 静态资源测试父类
 * @author: liuhang
 * @create: 2019-09-05 11:23
 **/
public class Father implements Person {
    static {
        value="2";
    }
    public static String value = "1";


    public static void test(){
        value="3";
    }
}
