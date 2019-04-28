package com.lm.design.create.factory.abstractfactory;

/**
 * 工厂创造类生成器
 * @Author: limeng
 * @Date: 2019/4/28 0:15
 */
public class FactoryProducer {
    public static AbstractFactory getAbstractFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPR")){
            return new ShapeFactory();
        }else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return  null;
    }
}
