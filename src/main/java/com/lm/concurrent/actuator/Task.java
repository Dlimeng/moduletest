package com.lm.concurrent.actuator;

/**
 * @Author: limeng
 * @Date: 2019/5/11 11:37
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name "+name);
    }

}
