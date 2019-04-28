package com.lm.design.create.factory.abstractfactory;

/**
 * @Author: limeng
 * @Date: 2019/4/27 23:32
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String name) {
        if(name.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(name.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    Color getColor(String name) {
        return null;
    }
}
