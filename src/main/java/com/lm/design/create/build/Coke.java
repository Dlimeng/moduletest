package com.lm.design.create.build;

/**
 * 可乐
 * @Author: limeng
 * @Date: 2019/4/28 21:51
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke ";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
