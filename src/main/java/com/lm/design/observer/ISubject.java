package com.lm.design.observer;

/**
 * 主题接口
 * @Classname ISubject
 * @Description TODO
 * @Date 2020/1/23 14:11
 * @Created by limeng
 */
public interface ISubject {
    void registerObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    void notifyObserver();
}
