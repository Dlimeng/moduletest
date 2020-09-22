package com.lm.concurrent.actuator;

import java.util.concurrent.*;

/**
 * @Author: limeng
 * @Date: 2019/5/11 11:32
 *  new Thread 显示创建线程方式，对象数不清，如果不及时关闭导致内存溢出，因此还要考虑线程管理等问题
 */
public class Server {
    private ThreadPoolExecutor executor;


    public Server() {
        /**
         * 线程池不允许使用Executors去创建而是ThreadPoolExecutor 方式，
         * 这样处理明确线程池运行规则，避免资源耗尽的
         */


        executor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardOldestPolicy());



        executor.execute(()->{
            try {
                new Task("aa").run();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                executor.shutdown();
            }
        });

    }

    /**
     * corePoolSize : corePoolSize线程池中要保持的数量，即时它们是空闲的除非设置allowCoreThreadTimeOut属性为true
     * maximumPoolSize:最大允许在池中最大线程数
     * keepAliveTime：当线程的数量大于核心时，这是空闲线程在终止之前等待新任务的最大时间。（超过核心的线程数的线程如果长时间获得不到新任务就会终止掉）
     * unit : keepAliveTime的单位 如TimeUnit.SECONDS 代表秒
     *  workQueue：工作队列（实现BlockingQueue接口的阻塞队列）用于在执行任务之前保存任务的队列。此队列只保留execute方法提交的Runnable任务。常使用的阻塞队列LinkedBlockingQueue、SynchronousQueue、ArrayBlockingQueue。使用SynchronousQueue队列表示，没有缓存队列在存储多余的线程。
     * threadFactory：创建线程时工厂
     * handler: 处理程序在执行被阻塞时使用的处理程序，因为达到线程边界和队列容量
     * handler有以下四种策略：
     *
     * ThreadPoolExecutor.AbortPolicy():丢弃任务并抛出RejectedExecutionException异常。 （ThreadPoolExecutor默认）
     * ThreadPoolExecutor.CallerRunsPolicy()：由调用线程处理该任务 。
     * ThreadPoolExecutor.DiscardPolicy()：也是丢弃任务，但是不抛出异常。 
     * ThreadPoolExecutor.DiscardOldestPolicy()：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     */

    /**
     *  创建新线程，空闲线程会被保留60秒
     *  初始线程数0
     *
     *  很灵活，弹性线程池线程管理，用多少线程给多大线程池，不用即时收回
     *  缺点：一旦线程无限增长，导致内存溢出
     *  SynchronousQueue 同步队列
     * @param threadFactory
     * @return
     */
    public ExecutorService newCachedThreadPool(ThreadFactory threadFactory){
        return new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),threadFactory);
    }


    public static ExecutorService newFixedThreadPool(int nThreads){
        return new ThreadPoolExecutor(nThreads,nThreads,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    }

    public static ExecutorService newSingleThreadExecutor(){
       /* return new FinalizableDelegatedExecutorService
                (new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()));*/
       return null;
    }

    /**
     * 用于预定执行而构建的固定线程池， java.util.Timer
     * @return
     */
    public static ExecutorService newScheduledThreadPool(){
        Executors.newScheduledThreadPool(10);
        return null;
    }


    public static void main(String[] args) {
       // ExecutorService executorService = Executors.newCachedThreadPool();


    }

}
