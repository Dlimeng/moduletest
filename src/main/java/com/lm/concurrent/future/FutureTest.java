package com.lm.concurrent.future;

import com.lm.concurrent.actuator.ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Classname FutureTest
 * @Description TODO
 * @Date 2020/11/4 10:55
 * @Created by limeng
 * ResultDemo 相当于主线程和子线程之间的桥梁，通过它主子线程可以共享数据
 */
public class FutureTest {
    public static void main(String[] args) {
        ExecutorService pool = ThreadPool.newFixedThreadPool(5, "FutureTest", false);

        ResultDemo resultDemo = new ResultDemo();
        resultDemo.setAge(1);
        resultDemo.setName("test");

        Future<ResultDemo> future = pool.submit(new Task(resultDemo), resultDemo);

        try {
            ResultDemo resultDemo1 = future.get();
            System.out.println(resultDemo1.age);
            System.out.println(resultDemo1.name);
          //  future.cancel(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    static class Task implements Runnable{
        ResultDemo result;

        public Task(ResultDemo result) {
            this.result = result;
        }

        @Override
        public void run() {
            System.out.println(result.getAge());
            result.setName("test2");
        }
    }

    static class ResultDemo{
        private Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
