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
    private Allocator actr;
    private int balance;
    //转账
    public void transfer(AccountClassLock4 target,int amt){
        //申请转出和转入账号，直到成功
        while (!actr.apply(this,target)) { }

        try {
            //锁定转出账户
            synchronized (this){
                //锁定转入账户
                synchronized (target){
                    if(this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }

        } finally {
            actr.free(this,target);
        }
    }

    public static void main(String[] args) {


    }

}
class Allocator{
    private List<Object> als = new ArrayList<>();

    //一次申请所有资源
    synchronized boolean apply(Object from,Object to){

        if(als.contains(from) || als.contains(to)){
            return false;
        }else{
            als.add(from);
            als.add(to);
        }
        return true;
    }

    synchronized void free(Object from,Object to){
        als.remove(from);
        als.remove(to);
    }

}

