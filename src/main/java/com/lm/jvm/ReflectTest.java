package com.lm.jvm;

import java.lang.reflect.Method;

/**
 * v0版本
 * @Classname reflectTest
 * @Description TODO
 * @Date 2019/12/6 19:16
 * @Created by limeng
 */
public class ReflectTest {
    public static void target(int i){
        System.out.println("cc");
        new Exception("#"+i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("ReflectTest");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null,0);
    }
}
