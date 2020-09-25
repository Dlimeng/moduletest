package com.lm.design.observer;

/**
 * 观察者实现
 * @Classname SecondObserver
 * @Description TODO
 * @Date 2020/1/23 14:16
 * @Created by limeng
 */
public class SecondObserver  implements IObserver {
    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public void update(String s) {
        message = "SecondObserver 收到了" + s;
    }
}
