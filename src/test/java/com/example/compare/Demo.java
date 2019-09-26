package com.example.compare;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @description: 测试比较
 * @author: liuhang
 * @create: 2019-09-25 16:01
 **/
public class Demo {
    @Test
    public void test01(){

        int compare = StringUtils.compare("abc", "abe");

        System.out.println(compare);
    }
}
