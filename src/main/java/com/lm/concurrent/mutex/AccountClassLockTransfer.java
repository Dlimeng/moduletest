package com.lm.concurrent.mutex;

import lombok.Data;

/**
 * @Classname AccountClassLockTransfer
 * @Description TODO
 * @Date 2020/10/13 14:32
 * @Created by limeng
 * 操作全局锁
 */
@Data
public class AccountClassLockTransfer implements Runnable {

    public AccountClassLock2 src;

    public AccountClassLock2 target;

    public AccountClassLockTransfer(AccountClassLock2 src, AccountClassLock2 target) {
        this.src = src;
        this.target = target;
    }

    @Override
    public void run() {
        src.transfer(target,100);
    }
}
