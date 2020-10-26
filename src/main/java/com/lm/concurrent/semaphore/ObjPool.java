package com.lm.concurrent.semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @Classname ObjPool
 * @Description TODO
 * @Date 2020/10/26 20:19
 * @Created by limeng
 * 对象池，指的一次性创建出N个对象，之后所有线程重复利用这N个
 * 对象，当然对象在被释放前，也是不容许其他线程使用。
 *
 * 对象的互斥性
 */
public class ObjPool<T,R> {
    //用信号量实现限流器
    final List<T> pool;
    //构造函数
    final Semaphore sem;

    public ObjPool(T[] tArray){
        pool = new Vector<T>(){};
        int size = tArray.length;

        for (int i = 0; i < tArray.length; i++) {
            pool.add(tArray[i]);
        }

        sem = new Semaphore(size);
    }

    R exec(Function<T,R> func) throws InterruptedException {
        T t = null;
        try {
            sem.acquire();
            t = pool.remove(0);
            return func.apply(t);
        }finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) {
        String[] mess = new String[10];
        for (int i = 0; i < 10; i++) {
            mess[i] = "obj_"+i;
        }

        ObjPool<String, String> objPool = new ObjPool<>(mess);

        for (int i = 0; i < 100; i++) {
            Thread t1= new Thread(()->{
                try {
                    objPool.exec(t -> {
                        System.out.println("当前线程id:"+Thread.currentThread().getId()+",当前获取到的对象："+t);
                        return t;
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


}
