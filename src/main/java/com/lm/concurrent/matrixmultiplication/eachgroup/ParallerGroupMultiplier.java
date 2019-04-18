package com.lm.concurrent.matrixmultiplication.eachgroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵乘法 线程的数量由处理器决定
 * @author limeng
 * @version 1.0
 * @date 2019/4/18 9:00
 */
public class ParallerGroupMultiplier {
    void multiply(double[][] matrix1,double[][] matrix2,
                  double[][] result){
        List<Thread> threads = new ArrayList<>();
        int  row1 = matrix1.length;
        int numThreads = Runtime.getRuntime().availableProcessors();
        int startIndex,endIndex,step;
        //步长
        step = row1 / numThreads;
        startIndex = 0;
        endIndex = step;
        for (int i = 0; i < numThreads; i++) {
            GroupMultiplierTask groupMultiplierTask = new GroupMultiplierTask(result, matrix1, matrix2, startIndex, endIndex);

            Thread thread = new Thread(groupMultiplierTask);
            thread.start();
            threads.add(thread);
            startIndex = endIndex;
            endIndex = i==numThreads-2 ? row1 : endIndex+step;
        }

        for (Thread thread:threads){
            try {
                thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
