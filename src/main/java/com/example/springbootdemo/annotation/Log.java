package com.example.springbootdemo.annotation;


import java.lang.annotation.Annotation;
public class Log implements   Annotation {



    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
