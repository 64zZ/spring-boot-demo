package com.example.staticMethod;

import org.junit.Test;

/**
 * @program: spring-boot-demo
 * @description: 测试静态方法的调度
 * @author: liuhang
 * @create: 2019-09-09 14:53
 **/
public class Demo extends Thread {

    public static void sayHello(){
        System.out.println("Hello World!");
    }

    @Override
    public void run() {
        super.run();
        sayHello();
    }

    @Test
    public void test01(){
        Demo demo = new Demo();
        demo.start();
    }


}
