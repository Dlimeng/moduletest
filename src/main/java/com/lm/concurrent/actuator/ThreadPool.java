package com.lm.concurrent.actuator;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname ThreadPool
 * @Description TODO
 * @Date 2020/9/10 16:06
 * @Created by limeng
 */
public class ThreadPool {

    public static ThreadFactory threadFactory(String threadName,Boolean isDaemon){
        ThreadFactory result = new ThreadFactory(){
            AtomicInteger num = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(isDaemon);
                t.setName(threadName+num.incrementAndGet());
                return t;
            }
        };
        return result;
    }

    /**
     *  corePoolSize : corePoolSize线程池中要保持的数量，即时它们是空闲的除非设置allowCoreThreadTimeOut属性为true
     *  maximumPoolSize:最大允许在池中最大线程数
     *  keepAliveTime：当线程的数量大于核心时，这是空闲线程在终止之前等待新任务的最大时间。（超过核心的线程数的线程如果长时间获得不到新任务就会终止掉）
     *  unit : keepAliveTime的单位 如TimeUnit.SECONDS 代表秒
     *  workQueue：工作队列（实现BlockingQueue接口的阻塞队列）用于在执行任务之前保存任务的队列。此队列只保留execute方法提交的Runnable任务。常使用的阻塞队列LinkedBlockingQueue、SynchronousQueue、ArrayBlockingQueue。使用SynchronousQueue队列表示，没有缓存队列在存储多余的线程。
     *  threadFactory：创建线程时工厂
     *  handler: 处理程序在执行被阻塞时使用的处理程序，因为达到线程边界和队列容量
     *  handler有以下四种策略：
     *
     *  ThreadPoolExecutor.AbortPolicy():丢弃任务并抛出RejectedExecutionException异常。 （ThreadPoolExecutor默认）
     *  ThreadPoolExecutor.CallerRunsPolicy()：由调用线程处理该任务 。
     *  ThreadPoolExecutor.DiscardPolicy()：也是丢弃任务，但是不抛出异常。 
     *  ThreadPoolExecutor.DiscardOldestPolicy()：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     *
     * @param threadNum corePoolSize
     * @param threadName  maximumPoolSize
     * @param isDaemon
     * @return
     */
    public  static ThreadPoolExecutor newCachedThreadPool(int threadNum,String threadName,Boolean isDaemon){
        ThreadPoolExecutor threadPool =  new ThreadPoolExecutor(threadNum,threadNum,120L, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(10 * threadNum), threadFactory(threadName, isDaemon));
        //核心线程在规定时间内会被回收
        threadPool.allowCoreThreadTimeOut(true);
        return threadPool;
    }

    public  static ThreadPoolExecutor newFixedThreadPool(int threadNum,String threadName,Boolean isDaemon){
        return new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory(threadName, isDaemon));
    }

    public static ScheduledThreadPoolExecutor getDefaultScheduler(){
        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(20,threadFactory("BDP-Default-Scheduler-Thread-", false));
        scheduler.setMaximumPoolSize(20);
        scheduler.setKeepAliveTime(5,TimeUnit.MINUTES);
        return scheduler;
    }

}
