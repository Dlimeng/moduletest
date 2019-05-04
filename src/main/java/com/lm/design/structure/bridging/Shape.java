package com.lm.design.structure.bridging;

/**
 * 形状
 * @Author: limeng
 * @Date: 2019/5/1 20:37
 */
public abstract class Shape {

    protected  DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI =drawAPI;
    }
    public abstract void draw();
}
