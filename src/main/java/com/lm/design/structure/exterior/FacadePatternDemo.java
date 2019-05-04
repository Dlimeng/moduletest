package com.lm.design.structure.exterior;

/**
 * @Author: limeng
 * @Date: 2019/5/4 10:15
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
