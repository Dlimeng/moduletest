package com.lm.design.action.strategy;

/**
 * @Author: limeng
 * @Date: 2019/5/22 23:44
 */
public class OpearationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
