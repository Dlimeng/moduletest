package com.lm.design.action;

/**
 * @Author: limeng
 * @Date: 2019/5/8 22:45
 */
public class FileLogger  extends AbstractLogger{

    public FileLogger(int level) {
        this.level =level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG :"+message);
    }
}
