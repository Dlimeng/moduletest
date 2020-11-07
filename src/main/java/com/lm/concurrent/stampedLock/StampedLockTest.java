package com.lm.concurrent.stampedLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * @Classname StampedLockTest
 * @Description TODO
 * @Date 2020/11/7 14:26
 * @Created by limeng
 *
 * StampedLock 的锁，性能比读写锁要好
 *
 * 支持 ，写锁，悲观读锁，乐观读锁
 *
 * StampedLock 一定不要调用中断操作，如果需要支持中断功能，一定使用可中断的悲观读锁readLockInterruptibly() 和 写锁 writeLockInterruptibly()
 *
 */
public class StampedLockTest {
    final Map<String,String> map = new HashMap<>();

    final StampedLock sl = new StampedLock();


    public String get(String key){
        long stamp = sl.readLock();
        try {
            return map.get(key);
        }finally {
            sl.unlockRead(stamp);
        }
    }

    public String put(String k,String v){
        long stamp = sl.writeLock();
        try {
            return map.put(k,v);
        }finally {
            sl.unlockWrite(stamp);
        }
    }

}
