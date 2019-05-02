package com.lm.design.structure.bridging;

/**
 * @Author: limeng
 * @Date: 2019/5/1 20:39
 */
public class Circle extends Shape {
    private int x, y, radius;
    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }

    protected Circle(int x, int y, int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
