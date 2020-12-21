package com.lm.concurrent.future;

import org.apache.commons.lang.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Classname FutureTest4
 * @Description TODO
 * @Date 2020/12/19 15:34
 * @Created by limeng
 */
public class FutureTest4 {

    public static void main(String[] args) {

        T2Task t2Task = new T2Task();

        T1Task t1Task = new T1Task(null);

        Thread t2 = new Thread(t2Task);

        Thread t1 = new Thread(t1Task);

        t1.start();
        t2.start();

        while (StringUtils.isBlank(t2Task.getName())) {}
        t1Task.name = t2Task.getName();

    }

    static class T1Task implements  Runnable {
        private String name;

        public T1Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("T1：洗水壶");
                TimeUnit.SECONDS.sleep(1);

                System.out.println("T1:烧开水");
                TimeUnit.SECONDS.sleep(15);


                System.out.println("T1拿到茶叶："+name);

                System.out.println("T1:泡茶...");
                System.out.println("上茶："+name);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class T2Task implements  Runnable{
        private String name;

        public String getName(){
            return name;
        }

        @Override
        public void run() {

            try {
                System.out.println("T2:洗茶壶...");
                TimeUnit.SECONDS.sleep(1);

                System.out.println("T2:洗茶杯...");
                TimeUnit.SECONDS.sleep(2);

                System.out.println("T2:拿茶叶...");
                TimeUnit.SECONDS.sleep(1);

                this.name = "龙井";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
