package com.lm.design.action.blame;

import com.lm.design.action.blame.AbstractLogger;

/**
 * @Author: limeng
 * @Date: 2019/5/8 22:43
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("Error  :"+message);
    }
}
