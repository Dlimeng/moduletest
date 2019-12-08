package com.lm.jvm;

import java.lang.reflect.Method;

/**
 * @Classname ReflectTest5
 * @Description TODO
 * @Date 2019/12/7 15:32
 * @Created by limeng
 */
public class ReflectTest5 {
    public static void target(int i){

    }

    public static void main(String[] args) throws Exception {
        Class klass = Class.forName(ReflectTest5.class.getCanonicalName());
        Method method = klass.getMethod("target", int.class);
        method.setAccessible(true); // 关闭权限检查
         polluteProfile();
         long current = System.currentTimeMillis();
         for (int i = 1; i <= 2_000_000_000; i++)
         {
             if (i % 100_000_000 == 0) {
                 long temp = System.currentTimeMillis();
                 System.out.println(temp - current);
                 current = temp;
             }
             method.invoke(null, 128);
         }
    }


    public static void polluteProfile() throws Exception {
        Method method1 = ReflectTest5.class.getMethod("target1", int.class);
        Method method2 = ReflectTest5.class.getMethod("target2", int.class);
        for (int i = 0; i < 2000; i++) {
            method1.invoke(null, 0); method2.invoke(null, 0);
        }
    }

    public static void target1(int i) { }
    public static void target2(int i) { }
}
