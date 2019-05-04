package com.lm.design.structure.decoration;

/**
 * RedShapeDecorator 来装饰Shape对象
 * @Author: limeng
 * @Date: 2019/5/4 9:24
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
