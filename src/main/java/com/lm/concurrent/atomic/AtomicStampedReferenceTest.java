package com.lm.concurrent.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Classname AtomicStampedReferenceTest
 * @Description TODO
 * @Date 2020/11/23 20:13
 * @Created by limeng
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedRef =
                new AtomicStampedReference<Integer>(100, 0);

        Thread refT1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicStampedRef.compareAndSet(100, 101,
                        atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                log("thread refT1:" + atomicStampedRef.getReference());
                atomicStampedRef.compareAndSet(101, 100,
                        atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                log("thread refT1:" + atomicStampedRef.getReference());
            }
        });

        Thread refT2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedRef.getStamp();
                log("before sleep : stamp = " + stamp);    // stamp = 0
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log("after sleep : stamp = " + atomicStampedRef.getStamp());//stamp = 1
                boolean c3 = atomicStampedRef.compareAndSet(100, 101, stamp, stamp + 1);
                log("thread refT2:" + atomicStampedRef.getReference() + ",c3 is " + c3);        //true
            }
        });

        refT1.start();
        refT2.start();
    }

    private static void log(String logString) {
        System.out.println(logString);
    }
}
