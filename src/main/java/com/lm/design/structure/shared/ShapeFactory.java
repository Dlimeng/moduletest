package com.lm.design.structure.shared;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建工厂生成基于给定信息的实体类的对象
 * 享元
 * @Author: limeng
 * @Date: 2019/5/4 10:49
 */
public class ShapeFactory {
    private static final Map<String,Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);
        if(circle == null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }


}
