package com.lm.design.action.observed;

/**
 * 创建实体观察者类
 * @Author: limeng
 * @Date: 2019/5/27 22:03
 */
public class BinaryObserver extends Observed{

    public BinaryObserver(Subject subject) {
        this.subject =subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
