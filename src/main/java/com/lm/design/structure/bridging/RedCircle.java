package com.lm.design.structure.bridging;

/**
 * 红色的圆圈
 * @Author: limeng
 * @Date: 2019/5/1 20:36
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
