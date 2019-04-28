package com.lm.design.create.build;

/**
 * 素食汉堡
 * @Author: limeng
 * @Date: 2019/4/28 21:44
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
