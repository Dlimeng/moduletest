package com.lm.design.create.factory.abstractfactory;

/**
 * 抽象工厂类
 * @Author: limeng
 * @Date: 2019/4/27 23:30
 */
public abstract class AbstractFactory {
    abstract Shape getShape(String name);
    abstract Color getColor(String name);
}
