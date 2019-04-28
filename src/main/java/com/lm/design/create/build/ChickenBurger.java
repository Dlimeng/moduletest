package com.lm.design.create.build;

/**
 * 鸡肉汉堡
 * @Author: limeng
 * @Date: 2019/4/28 21:46
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
