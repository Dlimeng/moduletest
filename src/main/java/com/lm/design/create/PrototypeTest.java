package com.lm.design.create;

import com.lm.design.create.Prototype;
import com.lm.design.create.SerializableObject;

import java.io.IOException;

/**
 * 原型模型
 * 浅复制：将一个对象复制后，基本数据类型和变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。深复制完全彻底的复制。
 * @Author: limeng
 * @Date: 2019/4/27 19:21
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype = new Prototype();
        SerializableObject serializableObject = new SerializableObject();
        prototype.setSerializableObject(serializableObject);

        Prototype object1 = (Prototype)prototype.clone();
        Prototype object2 = (Prototype) prototype.deepClone();

        //浅复制 success
        String result = prototype.getSerializableObject() == object1.getSerializableObject() ? "success":"error";
        //深复制 error
        String result2 = prototype.getSerializableObject() == object2.getSerializableObject() ? "success":"error";

        System.out.println(result);
        System.out.println(result2);
    }
}
