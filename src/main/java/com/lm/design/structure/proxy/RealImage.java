package com.lm.design.structure.proxy;

/**
 * 实现接口的实体类
 * @Author: limeng
 * @Date: 2019/5/5 22:13
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("Displaying "+fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading "+fileName);
    }
}
