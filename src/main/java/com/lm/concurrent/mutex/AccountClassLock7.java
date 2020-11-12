package com.lm.concurrent.mutex;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AccountClassLock7
 * @Description TODO
 * @Date 2020/11/12 11:53
 * @Created by limeng
 */
@Data
public class AccountClassLock7 {
    private Allocator actr = Allocator.getInstance();
    private int balance;


    public AccountClassLock7(int balance) {
        this.balance = balance;
    }

    public void transfer(AccountClassLock7 target,int amt){
        actr.apply(this,target);
        try {
            if (this.balance > amt){
                this.balance -= amt;
                target.balance += amt;
            }
        }finally {
            actr.free(this,target);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            AccountClassLock7 a = new AccountClassLock7(200);
            AccountClassLock7 b = new AccountClassLock7(200);
            AccountClassLock7 c = new AccountClassLock7(200);

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


    static class Allocator{
        private static Allocator instance = new Allocator();

        public static Allocator getInstance() {
            return instance;
        }

        private Allocator(){}

        private List<Object> als = new ArrayList<>();

        synchronized void apply(Object a,Object b){

            while(als.contains(a) || als.contains(b)){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            als.add(a);
            als.add(b);
        }

        synchronized void free(Object a,Object b){
            als.remove(a);
            als.remove(b);
            this.notifyAll();
        }


    }
}


