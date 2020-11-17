package com.lm.concurrent.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: limeng
 * @Date: 2020-11-18 00:35
 * @Description:
 */
public class CacheTest2<K,V> {

    final Map<K,V> map = new HashMap<>();

    final ReadWriteLock rwl = new ReentrantReadWriteLock();

    final Lock r = rwl.readLock();

    final Lock w = rwl.writeLock();

    public V get(K key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    public V put(K key,V value){
        w.lock();
        try {
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }


    public V getByAdd(K key){

        r.lock();
        V value = null;
        try {
            value = map.get(key);
        }finally {
            r.unlock();
        }

        if(value != null) return value;

        w.lock();
        try {

            value = map.get(key);
            if(value == null){
                //value = "查询到数据"
                map.put(key ,value);
            }
        }finally {
            w.unlock();
        }
        return value;

    }

    public static void main(String[] args) {
        CacheTest2<String, String> cache = new CacheTest2<>();

        cache.put("key","value");
        System.out.println(cache.get("key"));
    }


}
