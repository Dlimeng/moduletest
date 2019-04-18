package com.lm.concurrent.matrixmultiplication.eachrow;

/**
 * @author limeng
 * @version 1.0
 * @date 2019/4/18 8:34
 */
public class RowMultiplierTask implements Runnable{
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private final int row;

    public RowMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int row) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }

    @Override
    public void run() {
        //第二矩阵列
        for (int j = 0; j < matrix2[0].length; j++) {
            result[row][j] = 0;
            for (int k = 0; k < matrix1[row].length; k++) {
                result[row][j] += matrix1[row][k] * matrix2[k][j];
            }
        }
    }
}
