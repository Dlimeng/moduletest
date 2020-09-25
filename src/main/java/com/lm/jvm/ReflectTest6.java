package com.lm.jvm;

import java.lang.reflect.Method;

/**
 * @Classname ReflectTest6
 * @Description TODO
 * @Date 2019/12/7 16:06
 * @Created by limeng
 */
public class ReflectTest6 {
    public static void target(int i){
        //
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName(ReflectTest6.class.getCanonicalName());
        Method method = klass.getMethod("target", int.class);
        method.setAccessible(true);//关闭权限
        polluteProfile();

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if(i % 100_000_000 == 0){
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);

        }
    }

    /**
     * 不是同个对象，但是equal.返回时目标方法的一份拷贝。
     * @throws Exception
     */
    public static void polluteProfile() throws Exception{
        Method method1 = ReflectTest6.class.getMethod("target", int.class);
        Method method2 = ReflectTest6.class.getMethod("target", int.class);
        if(method1.equals(method2)){
            System.out.println("method1 equals method2");
        }
        if(method1 == method2){
            System.out.println("method1 == method2");
        }
        for (int i = 0; i < 2000; i++) {
            method1.invoke(null,0);
            method2.invoke(null,0);
        }

    }

    public static void target1(int i) { }
    public static void target2(int i) { }
}
