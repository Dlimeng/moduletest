package com.lm.concurrent.lock;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname AQSLockTest
 * @Description TODO
 * @Date 2020/11/15 17:00
 * @Created by limeng
 */
public class AQSLockTest {
    final  static Queue<String> queue = new LinkedBlockingQueue<>();

    final static Lock lock = new ReentrantLock();

    final static Condition full =  lock.newCondition();

    final static Condition empty =  lock.newCondition();

    final static int QUEUE_MAX_SIZE = 3;
    public static void add() throws InterruptedException {
        lock.lock();
        try {
            //队列满了
            while (queue.size() == QUEUE_MAX_SIZE){
                full.await();
            }

            System.out.println(Thread.currentThread().getName()+ " prd:" + "hello");
            queue.add("test1-"+new Random().nextInt(100));
            empty.signalAll();

        }finally {
            lock.unlock();
        }
    }

    public static void  poll() throws InterruptedException {
        lock.lock();
        try {
            // 当队列queue中一个字符串都没有，就将剩下的消费线程丢进enpty对应的队列中
            while (queue.size() == 0) {
                empty.await();
            }

            // 消费队列queue中的字符串
            String poll = queue.poll();
            System.out.println(Thread.currentThread().getName()+ " consumer:" + poll);
            // 消费成功，就唤醒full中所有的生产线程去生产字符串
            full.signalAll();

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        // 生产者线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 消费者线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
