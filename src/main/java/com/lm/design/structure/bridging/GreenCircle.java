package com.lm.design.structure.bridging;

/**
 * @Author: limeng
 * @Date: 2019/5/1 20:37
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
