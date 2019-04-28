package com.lm.design.create.factory.abstractfactory;

/**
 * @Author: limeng
 * @Date: 2019/4/27 23:32
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Shape getShape(String name) {
        return null;
    }

    @Override
    Color getColor(String name) {
        if(name.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if(name.equalsIgnoreCase("RED")){
            return new Red();
        }
        return null;
    }
}
