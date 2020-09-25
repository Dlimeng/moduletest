package com.lm.jvm;

/**
 * // -XX:+PrintGC
 * // -XX:+PrintGCApplicationStoppedTime 打印所有引起jvm停顿时间
 * // -XX:+PrintSafepointStatistics
 * // -XX:+UseCountedLoopSafepoints
 * @Classname SafepointTest
 * @Description TODO
 * @Date 2019/12/22 14:25
 * @Created by limeng
 */
public class SafepointTest {
    static double sum = 0;
    public static void foo() {
        long current = System.currentTimeMillis();
        for (int i = 0; i < 0x77777777; i++) {
            sum += Math.sqrt(i);
        }
        long end = System.currentTimeMillis();
        System.out.println((end-current)/1000);
    }


    public static void bar() {
        long current = System.currentTimeMillis();
        for (int i = 0; i < 50_000_000; i++)
        { new Object().hashCode();
        }
        long end = System.currentTimeMillis();
        System.out.println((end-current)/1000);
    }



    public static void main(String[] args) {
       // new Thread(SafepointTest::foo).start();
        new Thread(SafepointTest::bar).start();
    }
}
