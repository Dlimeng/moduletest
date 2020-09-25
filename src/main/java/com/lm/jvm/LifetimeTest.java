package com.lm.jvm;

/**
 *
 * -XX:+PrintGC
 * -Xmn100M 堆中新生代大小
 * -XX:PretenureSizeThreshold=1000 设置大于这个值的对象直接在年老代分配
 *
 * -XX:+PrintHeapAtGC 打印GC前后的详细堆栈信息
 * -XX:SurvivorRatio=N
 * -XX:UsePSAdaptiveSurvivorSizePolicy 动态分配策略
 *
 * @Classname LifetimeTest
 * @Description TODO
 * @Date 2019/12/24 16:31
 * @Created by limeng
 */
public class LifetimeTest {
    private static final int K = 1024;
    private static final int M = K * K;
    private static final int G = K * M;

    private static final int ALIVE_OBJECT_SIZE = 32 * M;

    public static void main(String[] args) {
        int length = ALIVE_OBJECT_SIZE / 64;
        ObjectOf64Bytes[] array = new ObjectOf64Bytes[length];
        for (int i = 0; i < G; i++) {
            array[(int)(i % length)] = new ObjectOf64Bytes();
        }
    }
}
class ObjectOf64Bytes{
    long placeholder0;
    long placeholder1;
    long placeholder2;
    long placeholder3;
    long placeholder4;
    long placeholder5;
}