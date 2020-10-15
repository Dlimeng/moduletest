package com.lm.concurrent.mutex;

/**
 * @Classname AccountClassLockMain
 * @Description TODO
 * @Date 2020/10/12 11:51
 * @Created by limeng
 *
 * 假设有 A、B、C 三个账户，余额都是 200 元，我们用两个线程分别执行两个转账操作：
 * 账户 A 转给账户 B 100 元，账户 B 转给账户 C 100 元，
 * 最后我们期望的结果应该是账户 A 的余额是 100 元，账户 B 的余额是 200 元， 账户 C 的余额是 300 元。
 *
 * 第一种方式，把整个类加锁，所有调用对象全部串行化,缺点太慢，没有充分用资源
 */
public class AccountClassLockMain {
    public static void main(String[] args) throws InterruptedException {

        AccountClassLock2 a = new AccountClassLock2(200);
        AccountClassLock2 b = new AccountClassLock2(200);
        AccountClassLock2 c = new AccountClassLock2(200);


        Thread t1 = new Thread(new AccountClassLockTransfer(a,b));
        Thread t2 = new Thread(new AccountClassLockTransfer(b,c));

        t1.start();
        t2.start();


        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
        System.out.println(c.getBalance());


    }
}
