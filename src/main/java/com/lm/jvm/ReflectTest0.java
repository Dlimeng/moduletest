package com.lm.jvm;

import java.lang.reflect.Method;

/**
 * v0版本
 * @Classname reflectTest
 * @Description TODO
 * @Date 2019/12/6 19:16
 * @Created by limeng
 */
public class ReflectTest0 {
    /**
     * java.lang.Exception: #0
     * 	at com.lm.jvm.ReflectTest.target(ReflectTest.java:14)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at com.lm.jvm.ReflectTest.main(ReflectTest.java:20)
     *
     *  反射调用先是调用Method.invoke,然后然后进入委派实现DelegatingMethodAccessorImpl，
     *  再然后进入本地实现NativeMethodAccessorImpl，最后到达目标方法。
     * @param i
     */
    public static void target(int i){
        new Exception("#"+i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName(ReflectTest0.class.getCanonicalName());
        Method method = klass.getMethod("target", int.class);
        method.invoke(null,0);
    }
}
