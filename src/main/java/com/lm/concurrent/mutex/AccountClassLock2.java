package com.lm.concurrent.mutex;

import lombok.Data;

/**
 * @Classname AccountClassLock2
 * @Description TODO
 * @Date 2020/10/13 15:20
 * @Created by limeng
 */
@Data
public class AccountClassLock2 {
    private int balance;

    public AccountClassLock2( int balance) {
        this.balance = balance;
    }

    //转账（class级别的锁，不存在并发问题）
    void transfer(AccountClassLock2 target, int amt) {
        synchronized (AccountClassLock2.class){
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountClassLock2 a = new AccountClassLock2(200);
        AccountClassLock2 b = new AccountClassLock2(200);
        AccountClassLock2 c = new AccountClassLock2(200);


        Thread t1 = new Thread(()->{
            a.transfer(b,100);
        });


        Thread t2 = new Thread(()->{
            b.transfer(c,100);
        });

        t1.start();
        t2.start();
        t2.join();

        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
        System.out.println(c.getBalance());
    }

}
