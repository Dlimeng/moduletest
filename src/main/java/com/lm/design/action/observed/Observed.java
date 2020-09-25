package com.lm.design.action.observed;

/**
 * @Author: limeng
 * @Date: 2019/5/27 21:42
 */
public abstract class Observed {
    protected Subject subject;
    public abstract void update();
}
