package com.lm.jvm;

import java.lang.reflect.Method;

/**
 * v1版本
 * @Classname ReflectTest2
 * @Description TODO
 * @Date 2019/12/7 12:51
 * @Created by limeng
 */
public class ReflectTest1 {
    public static void target(int i){
        new Exception("#" + i).printStackTrace();
    }

    /**
     * 许多反射调用仅会执行一次，Java虚拟机设置了一个阈值15
     * （可以通过-Dsun.reflect.inflationThreshold=来调整），当某个反射调用次数15之下时，
     * 采用本地实现；当达到15时，便开始动态生成字节码，
     * 并将委派实现的委派对象切换至动态实现，这个过程我们称之为Inflation
     * @param args
     * @throws Exception
     */
    /**
     * java.lang.Exception: #15
     * 	at com.lm.jvm.ReflectTest2.target(ReflectTest2.java:14)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at com.lm.jvm.ReflectTest2.main(ReflectTest2.java:29)
     * java.lang.Exception: #16
     * 	at com.lm.jvm.ReflectTest2.target(ReflectTest2.java:14)
     * 	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at com.lm.jvm.ReflectTest2.main(ReflectTest2.java:29)
     * 	可以看到，在第16次（从0开始）反射调用，
     * 	我们便触发动态实现生成。这时候，Java虚拟机额外加载了不少类。
     * 	其中最重要的当属GeneratedMethodAccessor1 。
     * 	并且，从第16次反射调用开始，我们便切换至这个刚刚生成的动态实现。
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName(ReflectTest1.class.getCanonicalName());
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }
}
