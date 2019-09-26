package com.example.springbootdemo;

import com.example.springbootdemo.entity.Teacher;
import com.example.springbootdemo.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: liuhang
 * @create: 2019-08-02 13:41
 **/
public class Demo {


    @Test
    public void test01(){

        ArrayList<Object> lists = new ArrayList<>();
        User user = new User();
        user.setUserName("123");
        System.out.println(user);
        lists.add(user);

        user.setUserName("456");
        System.out.println(user);
        lists.add(user);

        user.setUserName("789");
        System.out.println(user);
        lists.add(user);

        user.setUserName("1231");
        System.out.println(user);
        lists.add(user);

        System.out.println(lists);

        Teacher teacher = new Teacher();
        List<User> users = teacher.getLists();
        System.out.println(teacher);



    }

    @Test
    public void test02(){
        System.out.println(UUID.randomUUID().toString().toLowerCase());
    }

    @Test
    public void test03(){
        String temp = ",123,123,";
        System.out.println(temp.split(",").length);
        System.out.println();
    }
}
