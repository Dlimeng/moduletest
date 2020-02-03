package com.lm.jvm.oom;

/**
 * -Xss 每个线程堆栈大小
 * 创建线程导致内存溢出异常
 * @Classname JavaVMStackOOM
 * @Description TODO
 * @Date 2020/1/24 16:04
 * @Created by limeng
 */
public class JavaVMStackOOM {

    private void donStop(){
        while (true){

        }
    }


    public void stackLeakByThread(){
        while (true){
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });

            thread.start();
        }
    }

    public static void main(String[] args) {
        final JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
