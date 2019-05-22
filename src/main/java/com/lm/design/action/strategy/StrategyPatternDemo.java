package com.lm.design.action.strategy;

/**
 * 策略模式
 * @Author: limeng
 * @Date: 2019/5/22 23:51
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OpearationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OpearationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OpearationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
