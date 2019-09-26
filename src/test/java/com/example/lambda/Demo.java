package com.example.lambda;

import com.example.springbootdemo.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: spring-boot-demo
 * @description: 测试lambda表达式
 * @author: liuhang
 * @create: 2019-09-17 10:35
 **/
public class Demo {
    @Test
    public void test01(){
        List<User> list = new ArrayList<User>();
        list.add(new User());

        list.stream().forEach(x->{
            x.setUserName("123");
            x.setPassword("123");
        });
        System.out.println(list);
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: lanmba表达式集合排序
     * @Return: void
     * @Author: coder_64zZ
     * @Date: 2019/9/18 9:45
     */
    @Test
    public void test02(){

        ArrayList<User> list = new ArrayList<>();
        User user = new User();
        user.setPassword("123");
        user.setUserName("2123");
        user.setAge(123);

        User user1 = new User();
        user1.setPassword("123");
        user1.setUserName("2123");
        user1.setAge(13);

        User user2 = new User();
        user2.setPassword("123");
        user2.setUserName("2123");
        user2.setAge(3);

        User user3 = new User();
        user3.setPassword("123");
        user3.setUserName("2123");
        user3.setAge(1);
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        System.out.println(list);
        list.sort(Comparator.comparing(User::getAge));
        System.out.println(list);


    }

    /**
     * 遍历获取当前index
     */
    @Test
    public void test03(){
        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("12");
        list.add("12");
        list.add("12");
        list.add("12");
        list.forEach(x-> System.out.println(x));
    }
}
