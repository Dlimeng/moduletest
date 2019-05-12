package com.lm.concurrent.actuator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: limeng
 * @Date: 2019/5/12 19:23
 */
public class FactorialCalculatorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = null;
        //ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
        FactorialCalculator factorialCalculator = new FactorialCalculator(2);
        executorService.submit(factorialCalculator);
    }
}
