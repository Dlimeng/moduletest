package com.lm.concurrent.matrixmultiplication.eachelement;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个元素一个线程
 * @author limeng
 * @version 1.0
 * @date 2019/4/16 19:11
 */
public class IndividualMultiplierTask implements Runnable{

    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private final int row;
    private final int column;

    public IndividualMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int row, int column) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
        this.column = column;
    }

    @Override
    public void run() {
        result[row][column] = 0;
        for (int k = 0; k < matrix1[row].length; k++) {
            result[row][column] += matrix1[row][k] * matrix2[k][column];
        }
    }
}
class ParallelIndividualMultiplier{
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
}