package com.lm.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Classname CompletableFutureTest
 * @Description TODO
 * @Date 2020/11/28 16:13
 * @Created by limeng
 * 异步
 * runAsync(Runnable runnable) 和 supplyAsync(Supplier<U> supplier)
 * 之间区别 Runnable接口的run()方法没有返回值，而Supplier接口的get()方法是有返回值的。
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        //任务1：洗水壶-》烧开水
        //任务2：洗水壶-》洗茶杯-》拿茶叶
        //任务3：任务1 和 任务2完成后执行：泡茶
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(()->{
            System.out.println("T1:洗水壶...");
            sleep(1,TimeUnit.SECONDS);

            System.out.println("T1:烧开水...");
            sleep(15,TimeUnit.SECONDS);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
            System.out.println("T2:洗茶壶...");
            sleep(2,TimeUnit.SECONDS);

            System.out.println("T2:洗茶杯...");
            sleep(2, TimeUnit.SECONDS);

            System.out.println("T2:拿茶叶...");
            sleep(1,TimeUnit.SECONDS);
            return "龙井";
        });

        CompletableFuture f3 =
          f1.thenCombine(f2,(__,tf)->{
            System.out.println("T1:拿到茶叶:" + tf);
            System.out.println("T1:泡茶...");
            return "上茶:" + tf;
        });

        //等待任务3执行结果
        System.out.println(f3.join());

    }

    static void sleep(int t,TimeUnit u){
        try {
            u.sleep(t);
        }catch (InterruptedException e){}
    }

}
