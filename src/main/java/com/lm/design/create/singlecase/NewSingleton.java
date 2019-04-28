package com.lm.design.create.singlecase;

/**
 * 懒汉
 * 线程安全
 * @Author: limeng
 * @Date: 2019/4/25 22:18
 */
public class NewSingleton {

    private NewSingleton(){
    }

    public static class  NewSingletonFactory{
       private static NewSingleton newSingleton = new NewSingleton();
    }

    public static  NewSingleton getNewSingletonFactory(){
        return NewSingletonFactory.newSingleton;
    }

    /**
     * 该对象可用于序列化
     * @return
     */
    public Object readResolve(){
        return getNewSingletonFactory();
    }
}
