package com.lm.jvm;

import java.lang.reflect.Method;

/**
 *  -XX:+PrintGC
 * @Classname ReflectTest3
 * @Description TODO
 * @Date 2019/12/7 15:51
 * @Created by limeng
 */
public class ReflectTest3 {
   public static void target(int i){

   }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName(ReflectTest3.class.getCanonicalName());
        Method method = klass.getMethod("target", int.class);

        Object[] arg = new Object[1];
        arg[0] = 128;

        long current = System.currentTimeMillis();
        for (int i = 0; i <=2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, arg);

        }

    }

}
