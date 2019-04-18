package com.lm.concurrent.matrixmultiplication.eachelement;

import com.lm.concurrent.matrixmultiplication.MatrixGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 矩阵乘法 每个元素一个线程
 * @author limeng
 * @version 1.0
 * @date 2019/4/17 8:37
 */
public class ParallelIndividualMultiplier {
    void multiply(double[][] matrix1,double[][] matrix2,double[][] result){
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        int rows2 =matrix2.length;

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < rows2; j++) {
                IndividualMultiplierTask task = new IndividualMultiplierTask(result, matrix1, matrix2, i, j);
                Thread thread = new Thread(task);
                thread.start();
                threads.add(thread);
                if(threads.size() % 10 == 0){
                    waitForThreads(threads);
                }
            }
        }

    }

    private void waitForThreads(List<Thread> threads){
        for (Thread thread:threads){
            try {
                thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        threads.clear();
    }

    @Test
    public void init(){
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000,2000);

        double[][] result = new double[matrix1.length][matrix2[0].length];

        Date start = new Date();
        this.multiply(matrix1,matrix2,result);
        Date end = new Date();
        //time:414229
        System.out.printf("time:"+(end.getTime() - start.getTime()));
    }
}
