package com.lm.design.create.build;

/**
 * 冷饮
 * @Author: limeng
 * @Date: 2019/4/28 21:43
 */
public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price() ;
}
