package com.lm.concurrent.lock;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Account
 * @Description TODO
 * @Date 2020/10/22 11:21
 * @Created by limeng
 */
@Data
public class Account {
   private int balance;
   private final Lock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public void transfer(Account tar, int amt) throws InterruptedException {
        boolean flag = true;
        Random random = new Random();
        while (flag){
           if(this.lock.tryLock(random.nextInt(1000)+1, TimeUnit.MILLISECONDS)) {
               try {
               if (tar.lock.tryLock())
               {
                   try {
                       this.balance -= amt;
                       tar.balance += amt;
                       flag = false;
                   }
                   finally {
                       tar.lock.unlock();
                   }
               }//if
               } finally {
                   this.lock.unlock();
               }
           }
       }
   }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10000; i++) {
            Account a = new Account(200);
            Account b = new Account(200);
            Account c = new Account(200);

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
            System.out.println("---------------");

        }

    }

}
