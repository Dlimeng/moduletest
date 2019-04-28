package com.lm.design.create.build;

/**
 * 创建一个表示食物条目和食物包装的接口。
 * @Author: limeng
 * @Date: 2019/4/28 21:31
 */
public interface Item {
    String name();
    Packing packing();
    float price();
}
