package com.lm.design.observer;

/**
 * 观察者实现
 * @Classname FirstObserver
 * @Description TODO
 * @Date 2020/1/23 14:16
 * @Created by limeng
 */
public class FirstObserver implements IObserver {
    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public void update(String s) {
        message = "FirstObserver 收到了" + s;
    }
}
