package com.lm.concurrent.mutex;

import lombok.Data;

/**
 * @Classname AccountClassLock5
 * @Description TODO
 * @Date 2020/10/26 11:09
 * @Created by limeng
 * 破坏循环
 * 我们假设每个账户都有不同的属性 id，这个 id 可以作为排序字段，
 * 申请的时候，我们可以按照从小到大的顺序来申请。
 */
@Data
public class AccountClassLock5 {
    private int id;
    private int balance;

    public AccountClassLock5(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void transfer(AccountClassLock5 target,int amt){

        AccountClassLock5 left = this;
        AccountClassLock5 right = target;

        if(left.id > right.id){
            left = target;
            right = this;
        }

        synchronized (left){
            synchronized (right){
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            AccountClassLock5 a = new AccountClassLock5(1, 200);
            AccountClassLock5 b = new AccountClassLock5(2, 200);
            AccountClassLock5 c = new AccountClassLock5(3, 200);

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
            System.out.println("----------------");
        }



    }

}
