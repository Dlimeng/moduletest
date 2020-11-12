package com.lm.concurrent.mutex;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AccountClassLock4
 * @Description TODO
 * @Date 2020/10/17 19:06
 * @Created by limeng
 * 破坏占用且等待条件
 * 要破话这个条件，可以一次性申请所有资源。
 *
 */
@Data
public class AccountClassLock4 {
    private Allocator actr = Allocator.getInstance();
    private int balance;

    public AccountClassLock4(int balance) {
        this.balance = balance;
    }

    //转账
    public void transfer(AccountClassLock4 target,int amt){
        //申请转出和转入账号，直到成功
        while (!actr.apply(this,target)) {  }
        try {
            synchronized (this){
                synchronized (target){
                    if (this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }

                }
            }
        }finally {
            actr.free(this,target);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            AccountClassLock4 a = new AccountClassLock4(200);
            AccountClassLock4 b = new AccountClassLock4(200);
            AccountClassLock4 c = new AccountClassLock4(200);

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
class Allocator{

    private static Allocator instance = new Allocator();

    public static Allocator getInstance() {
        return instance;
    }

    private Allocator(){}

    private List<Object> als = new ArrayList<>();

    synchronized boolean apply(Object a,Object b){

        if(als.contains(a) || als.contains(b)){
            return false;
        }else{
            als.add(a);
            als.add(b);
        }
        return true;
    }

    synchronized void free(Object a,Object b){
        als.remove(a);
        als.remove(b);
    }

}

