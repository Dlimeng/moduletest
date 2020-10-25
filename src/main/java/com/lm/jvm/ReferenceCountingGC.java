package com.lm.jvm;

import org.junit.Test;

/**
 * @Auther: limeng
 * @Date: 2020-03-01 19:01
 * @Description:
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024*1024;
    //占内存
    private byte[] bigSize = new byte[2 *_1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();

    }

    public static void main(String[] args) {
        testGC();
    }
}
