package com.lm.concurrent.actuator;

import java.util.concurrent.TimeUnit;

/**
 * @Classname ScheduledExecutorServiceTest1
 * @Description TODO
 * @Date 2020/11/27 18:38
 * @Created by limeng
 */
public class ScheduledExecutorServiceTest1 {
    /**
     * initialDelay 说系统启动后，需要等待多久才开始执行。
     * period 为固定周期时间，按照一定频率来重复执行任务。
     * 如果period设置的是3秒，系统执行要5秒，那么等上一次任务立即执行，也就是任务与任务之间的差异是5s
     * 如果period设置的是3秒，系统执行要2秒，那么需要等待3后再次执行下一次任务
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("task begin:"+System.currentTimeMillis()/1000);
        ThreadPool.getDefaultScheduler().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--task run:"+System.currentTimeMillis()/1000);
            }
        },2,3, TimeUnit.SECONDS);


    }
}
