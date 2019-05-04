package com.lm.design.structure.decoration;

/**
 * 实体装饰类
 * @Author: limeng
 * @Date: 2019/5/4 9:19
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
