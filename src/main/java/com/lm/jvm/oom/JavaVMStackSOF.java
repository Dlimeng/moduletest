package com.lm.jvm.oom;

/**
 * 单个线程，无论栈帧太大还是虚拟机容量太小，当内存无法分配时候，
 * 虚拟机抛出都是StackOverflowError
 * -Xss128k
 * @Classname JavaVMStackSOF
 * @Description TODO
 * @Date 2020/1/24 1:02
 * @Created by limeng
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
           oom.stackLeak();
        }catch (Exception e){
            System.out.println("stack lengtj:"+ oom.stackLength);
            throw e;
        }
    }
}
