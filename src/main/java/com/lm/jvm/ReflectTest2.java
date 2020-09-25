package com.lm.jvm;

import java.lang.reflect.Method;

/**
 * v2版本
 * @Classname ReflectTest3
 * @Description TODO
 * @Date 2019/12/7 14:00
 * @Created by limeng
 */
public class ReflectTest2 {
    public static void target(int i){
        //空方法
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName(ReflectTest2.class.getCanonicalName());
        Method method = klass.getMethod("target", int.class);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if(i % 100_000_000 == 0){
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null,128);
        }


    }
}
