package com.lm.concurrent.matrixmultiplication;

import org.junit.Test;

import java.util.Date;
import java.util.Random;

/**
 * 矩阵乘法串行版本
 * @author limeng
 * @version 1.0
 * @date 2019/4/16 18:28
 */
public class MatrixGenerator {
    /**
     *
     * @param rows
     * @param columns
     * @return
     */
    double[][] generate(int rows,int columns){
        double[][] ret = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ret[i][j] = random.nextDouble()*10;
            }
        }
        return ret;
    }

    void multiply(double[][] matrix1,double[][] matrix2,double[][] result){
        int row1=matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < columns1; j++) {
                result[i][j] = 0;
                for (int k = 0; k < columns2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }

    @Test
    void init(){
        double[][] matrix1 = this.generate(2000, 2000);
        double[][] matrix2 = this.generate(2000,2000);

        double[][] result = new double[matrix1.length][matrix2[0].length];

        Date start = new Date();
        this.multiply(matrix1,matrix2,result);
        Date end = new Date();

        System.out.printf("time:"+(end.getTime() - start.getTime()));
    }
}
