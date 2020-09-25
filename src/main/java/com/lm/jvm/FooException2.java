package com.lm.jvm;

/**
 * @Classname FooException2
 * @Description TODO
 * @Date 2019/12/4 11:15
 * @Created by limeng
 */
public class FooException2 {

    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;


    public void test(){
        try{
            tryBlock = 0;
        }catch (Exception e){
            catchBlock = 1;
        }finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }
}

/**
 * $ javap -c Foo...
 * public void test();
 * Code:
 *   0: aload_0  将一个局部变量加载到操作栈
 *   1: iconst_0 将一个常量加载到操作数栈
 *   2: putfield  #20 // Field tryBlock:I
 *   5: goto 30
 *   8: astore_1  将一个数值从操作数栈存储到局部变量表
 *   9: aload_0
 *   10: iconst_1
 *   11: putfield #22 // Field catchBlock:I
 *   14: aload_0
 *   15: iconst_2
 *   16: putfield #24 // Field finallyBlock:I
 *   19: goto 35
 *   22: astore_2
 *   23: aload_0
 *   24: iconst_2
 *   25: putfield #24 // Field finallyBlock:I
 *   28: aload_2
 *   29: athrow
 *   30: aload_0
 *   31: iconst_2
 *   32: putfield #24 // Field finallyBlock:I
 *   35: aload_0
 *   36: iconst_3
 *   37: putfield #26 // Field methodExit:I
 *   40: return
 *   Exception table:
 *   from to target type
 *   0 5 8 Class java/lang/Exception
 *   0 14 22 any ...
 *
 *
 *
 *
 *
 **/