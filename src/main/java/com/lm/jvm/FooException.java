package com.lm.jvm;

import org.junit.Test;

/**
 * 异常字节码
 * @Classname FooException
 * @Description TODO
 * @Date 2019/12/3 12:03
 * @Created by limeng
 */
public class FooException {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            try {
                tryBlock = 0;
                if (i < 50) { continue; }
                else if (i < 80) { break; }
                else { return; }
            }catch (Exception e){
                catchBlock = 1;
            }finally {
                finallyBlock = 2;
            }
            methodExit = 3;
        }
    }


}
