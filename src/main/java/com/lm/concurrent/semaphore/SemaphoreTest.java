package com.lm.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Classname SemaphoreTest
 * @Description TODO
 * @Date 2020/10/26 19:54
 * @Created by limeng
 * 允许多个线程同时操作
 * 限流器
 */
public class SemaphoreTest {
    static int count;

    static final Semaphore s = new Semaphore(1);

    static void addOne(){
        try {
            s.acquire();
            count +=1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            s.release();
        }
    }



    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            SemaphoreTest.addOne();
        });

        Thread t2 = new Thread(()->{
            SemaphoreTest.addOne();
        });

        Thread t3 = new Thread(()->{
            SemaphoreTest.addOne();
        });


        t1.start();
        t2.start();
        t3.start();

        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(SemaphoreTest.count);
    }
}
