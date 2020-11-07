package com.lm.concurrent.mutex;

import lombok.Data;

/**
 * @Classname AccountClassLock3
 * @Description TODO
 * @Date 2020/10/17 18:14
 * @Created by limeng
 * 提升全局锁的性能
 *
 * 假设有 A、B、C 三个账户，余额都是 200 元，我们用两个线程分别执行两个转账操作：
 * 账户 A 转给账户 B 100 元，账户 B 转给账户 C 100 元，
 * 最后我们期望的结果应该是账户 A 的余额是 100 元，账户 B 的余额是 200 元， 账户 C 的余额是 300 元。
 *
 * 转账 都在账本上，支持并发。
 * 两把锁
 * 转出一把，转入一把
 *
 * 导致死锁：
 * 两个线程 ：A 转 B 100 ，B 转 A 100
 * 预防死锁：
 * 互斥，共享资源X和Y 只能 被一个线程占用
 * 占有且等待，线程T1 已经取得共享资源X,在等待共享资源Y的时候，不释放共享资源X.
 * 不可抢占，其他线程强行抢占线程T1占有的资源。
 * 循环等待，线程T1等待线程T2占有资源，线程T2等待线程T1占有的资源，就是循环等待。
 * 破坏其中一个就是死锁。
 *
 * 解决方案：
 * 对于“占用且等待”这个条件，我们可以一次性申请所有的资源，这样就不存在等待了。
 * 对于“不可抢占”这个条件，占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源，这样不可抢占这个条件就破坏掉了。
 * 对于“循环等待”这个条件，可以靠按序申请资源来预防。
 * 所谓按序申请，是指资源是有线性顺序的，申请的时候可以先申请资源序号小的，再申请资源序号大的，这样线性化后自然就不存在循环了。
 *
 */
@Data
public class AccountClassLock3 {
    private int balance;

    public AccountClassLock3(int balance) {
        this.balance = balance;
    }

    public void transfer(AccountClassLock3 target,int amt){
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
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            AccountClassLock3 a = new AccountClassLock3(200);
            AccountClassLock3 b = new AccountClassLock3(200);
            AccountClassLock3 c = new AccountClassLock3(200);


            Thread t1 = new Thread(()->{
                a.transfer(b,100);
            });



            Thread t2 = new Thread(()->{
                b.transfer(a,100);
            });
            t1.start();
            t2.start();

            t2.join();

            System.out.println(a.getBalance());
            System.out.println(b.getBalance());
            //System.out.println(c.getBalance());
            System.out.println("---------------");
        }
    }
}
