package com.lm.concurrent.actuator;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname TestNewScheduledThreadPool
 * @Description TODO
 * @Date 2020/9/24 18:51
 * @Created by limeng
 */
public class TestNewScheduledThreadPool {
    public static void main(String[] args) {
            ScheduledThreadPoolExecutor exec = ThreadPool.getDefaultScheduler();
            exec.scheduleAtFixedRate(new Runnable() {
                //每隔一段时间就触发异常
                @Override
                public void run() {
                    //throw new RuntimeException();
                    System.out.println("================");
                }
            }, 1000, 5000, TimeUnit.MILLISECONDS);
            //每隔一段时间打印系统时间，证明两者是互不影响的
            exec.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(System.nanoTime());
                }

            }, 1000, 2000, TimeUnit.MILLISECONDS);
    }
}
