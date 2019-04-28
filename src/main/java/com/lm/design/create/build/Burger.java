package com.lm.design.create.build;

/**
 *  汉堡
 * @Author: limeng
 * @Date: 2019/4/28 21:38
 */
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
