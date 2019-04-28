package com.lm.design.create.factory.abstractfactory;

/**
 * @Author: limeng
 * @Date: 2019/4/28 0:17
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeAbstractFactory = FactoryProducer.getAbstractFactory("SHAPR");

        Shape circle = shapeAbstractFactory.getShape("CIRCLE");
        circle.draw();

        AbstractFactory colorAbstractFactory = FactoryProducer.getAbstractFactory("COLOR");
        Color green = colorAbstractFactory.getColor("GREEN");
        green.fill();


    }
}
