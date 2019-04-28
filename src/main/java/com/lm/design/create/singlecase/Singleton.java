package com.lm.design.create.singlecase;

/**
 * 单例通用模板
 * @Author: limeng
 * @Date: 2019/4/25 21:39
 */
public class Singleton {
    private static final Singleton singleton= new Singleton();

    /**
     * 限制产生多个对象
     */
    private Singleton(){

    }

    /**
     * 通过该方法获得实例对象
     */
    public static void doSomething(){

    }

}
