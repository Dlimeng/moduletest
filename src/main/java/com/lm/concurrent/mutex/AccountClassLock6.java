package com.lm.concurrent.mutex;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname AccountClassLock6
 * @Description TODO
 * @Date 2020/10/26 11:28
 * @Created by limeng
 * 破坏不可抢占条件
 */
@Data
public class AccountClassLock6 {
    private int balance;

    private final Lock locks = new ReentrantLock();

    public AccountClassLock6(int balance) {
        this.balance = balance;
    }

    public void transfer(AccountClassLock6 target,int amt) throws InterruptedException {
        boolean flag = true;
        Random random = new Random();
        while (flag){
            if(this.locks.tryLock(random.nextInt(1000)+1 , TimeUnit.MILLISECONDS)){
                try {
                    if(target.locks.tryLock()){
                        try {
                            if(this.balance > amt){
                                this.balance -= amt;
                                target.balance += amt;
                                flag = false;
                            }
                        }finally {
                            target.locks.unlock();
                        }
                    }
                }finally {
                    this.locks.unlock();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            AccountClassLock6 a = new AccountClassLock6(200);
            AccountClassLock6 b = new AccountClassLock6(200);
            AccountClassLock6 c = new AccountClassLock6(200);

            Thread t1 = new Thread(()->{
                try {
                    a.transfer(b,100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


            Thread t2 = new Thread(()->{
                try {
                    b.transfer(c,100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


            t1.start();
            t2.start();

            t2.join();

            System.out.println(a.getBalance());
            System.out.println(b.getBalance());
           System.out.println(c.getBalance());
            System.out.println("----------------");

        }
    }

}
