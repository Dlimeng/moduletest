package com.lm.design.action;

/**
 * @Author: limeng
 * @Date: 2019/5/8 22:40
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("info :"+message);
    }
}
