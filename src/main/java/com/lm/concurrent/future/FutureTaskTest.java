package com.lm.concurrent.future;

import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Classname FutureTaskTest
 * @Description TODO
 * @Date 2020/11/19 10:22
 * @Created by limeng
 * 烧水泡茶最优程序
 * t1 线程 洗水壶 1，烧开水 15，泡茶
 * t2 线程 洗茶壶 1，洗茶杯 2， 拿茶叶 1
 */
@Data
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> ft2 = new FutureTask<>(new T2Task());

        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

        Thread t1 = new Thread(ft1);
        t1.start();

        Thread t2 = new Thread(ft2);
        t2.start();

        System.out.println(ft1.get());

    }


    static class  T1Task implements Callable<String> {
        FutureTask<String> t2;

        public T1Task(FutureTask t2) {
            this.t2 = t2;
        }

        @Override
        public String call() throws Exception {
            System.out.println("T1:洗水壶...");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T1:烧开水");
            TimeUnit.SECONDS.sleep(15);

            String o = t2.get();
            System.out.println("T1拿到茶叶："+o);

            System.out.println("T1:泡茶...");
            return "上茶:" + o;
        }
    }


    static class T2Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("T2:洗茶壶...");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T2:洗茶杯...");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("T2:拿茶叶...");
            TimeUnit.SECONDS.sleep(1);

            return "龙井";
        }
    }
}
