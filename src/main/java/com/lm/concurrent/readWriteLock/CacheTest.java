package com.lm.concurrent.readWriteLock;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Classname CacheTest
 * @Description TODO
 * @Date 2020/11/7 13:16
 * @Created by limeng
 * 并发包，很多工具类，原因分场景优化性能，提升易用性
 * 所有读写都遵守以下基本三条原则：
 * 允许多个线程同时读取共享变量。
 * 只允许一个线程写共享变量。
 * 如果一个写线程正在执行，此时禁止读线程读共享变量。
 *
 *ReadWriteLock 适合读多写少的场景
 */
public class CacheTest {
    final Map<String,String> m = new HashMap<String,String>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();

    //读锁
    final Lock r = rwl.readLock();

    //写锁
    final Lock w = rwl.writeLock();

    public String get(String key){
       r.lock();
       try {
           return m.get(key);
       }finally {
           r.unlock();
       }
    }

    public String put(String key,String value){
        w.lock();
        try {
            return m.put(key,value);
        }finally {
            w.unlock();
        }
    }


    public static void main(String[] args) {
        CacheTest cacheTest = new CacheTest();


    }

}
