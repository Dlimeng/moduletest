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
