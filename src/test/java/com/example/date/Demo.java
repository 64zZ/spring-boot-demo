package com.example.date;

import com.example.springbootdemo.util.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @description: 测试时间类
 * @author: liuhang
 * @create: 2019-09-21 11:46
 **/
public class Demo {

    @Test
    public void test01(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);

    }
}
