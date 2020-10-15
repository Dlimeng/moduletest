package com.lm.concurrent.mutex;

import lombok.Data;

/**
 * @Classname AccountClassLock
 * @Description TODO
 * @Date 2020/10/12 11:44
 * @Created by limeng
 * 假设有 A、B、C 三个账户，余额都是 200 元，我们用两个线程分别执行两个转账操作：
 * 账户 A 转给账户 B 100 元，账户 B 转给账户 C 100 元，
 * 最后我们期望的结果应该是账户 A 的余额是 100 元，账户 B 的余额是 200 元， 账户 C 的余额是 300 元。
 *
 *
 */
@Data
public class AccountClassLock {
    private int balance;

    public AccountClassLock( int balance) {
        this.balance = balance;
    }

    public void add(int amt){
        this.balance += amt;
    }

    public void minus(int amt){
        this.balance -= amt;
    }

}
