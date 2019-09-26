package com.example.staticTest;


import java.security.PrivateKey;

public interface Person {
    /**
     * 只能接口名调用
     */
    public static void person(){
        System.out.println("this is a person ");
    }

    public default  void defaultMethod(){
        System.out.println("default Method out");
    }
}
