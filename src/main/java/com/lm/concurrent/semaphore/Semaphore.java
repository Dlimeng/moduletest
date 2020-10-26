package com.lm.concurrent.semaphore;

import java.util.Queue;

/**
 * @Classname Semaphore
 * @Description TODO
 * @Date 2020/10/26 10:34
 * @Created by limeng
 */
public class Semaphore {
    //计数器
    int count;
    //等待队列
    Queue queue;

    public Semaphore(int count) {
        this.count = count;
    }
}
