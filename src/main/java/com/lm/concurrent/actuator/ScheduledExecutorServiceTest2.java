package com.lm.concurrent.actuator;

import java.util.concurrent.TimeUnit;

/**
 * @Classname ScheduledExecutorServiceTest2
 * @Description TODO
 * @Date 2020/11/27 18:58
 * @Created by limeng
 * initialDelay  是说系统启动后，需要等待多久才开始执行。
 * period 为固定周期时间，按照一定频率来重复执行任务。
 * 如果设置period为3s,任务执行耗时为5s那么下次任务执行时间8
 */
public class ScheduledExecutorServiceTest2 {
    public static void main(String[] args) {
        System.out.println("task begin:"+System.currentTimeMillis()/1000);
        ThreadPool.getDefaultScheduler().scheduleWithFixedDelay(new Runnable() {
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
