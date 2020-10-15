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

    void transferBasic(AccountClassLock2 target, int amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }

    //转账（class级别的锁，不存在并发问题）
    void transfer(AccountClassLock2 target, int amt) {
        synchronized(AccountClassLock2.class) {
            transferBasic(target, amt);
        }
    }

}
