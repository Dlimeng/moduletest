package com.lm.design.create.build;

/**
 * 实际的builder 类负责创建Meal对象
 * @Author: limeng
 * @Date: 2019/4/28 22:00
 */
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        //素食汉堡
        meal.addItem(new VegBurger());
        //可乐
        meal.addItem(new Coke());
        return meal;
    }

    public Meal  prepareNonVegMeal(){
        Meal meal = new Meal();
        //素食汉堡
        meal.addItem(new ChickenBurger());
        //可乐
        meal.addItem(new Pepsi());
        return meal;
    }
}
