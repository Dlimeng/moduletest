package com.lm.design.structure.bridging;

/**
 * 桥接
 * 把这种多角度与实现化解耦使二者可以独立变化
 * @Author: limeng
 * @Date: 2019/5/1 20:43
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape circle1 = new Circle(100, 100, 10, new RedCircle());
        Shape circle2 = new Circle(100, 100, 10, new GreenCircle());

        circle1.draw();
        circle2.draw();
    }
}
