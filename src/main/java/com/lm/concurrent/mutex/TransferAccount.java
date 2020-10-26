package com.lm.concurrent.mutex;

/**
 * @Classname TransferAccount
 * @Description TODO
 * @Date 2020/10/12 13:44
 * @Created by limeng
 */
public class TransferAccount implements Runnable {
    @Override
    public void run() {
        System.out.println("start");
        try {
           // this.wait();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new TransferAccount()).start();
       // Thread.sleep(10000);
        new Thread(new TransferAccount()).start();
    }
}
