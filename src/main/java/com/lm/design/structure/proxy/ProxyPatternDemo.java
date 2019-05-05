package com.lm.design.structure.proxy;

/**
 * @Author: limeng
 * @Date: 2019/5/5 22:20
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("ssss");
        proxyImage.display();
        proxyImage.display();
    }
}
