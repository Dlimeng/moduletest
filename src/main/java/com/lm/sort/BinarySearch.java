package com.lm.sort;

/**
 * 二分查找
 * 平均时间复杂度 o(lgn)
 * @Author: limeng
 * @Date: 2019/6/10 9:27
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrs =new int[]{10,20,30,40,50,60,70,80};
        int result = 40;
        System.out.println(search(arrs,result));
    }

    public static int search(int[] arr,int result){
        int row=0;
        int height = arr.length - 1;
        while (row <= height){
            int tmp = (row+height)/2;

            if(result < arr[tmp]){
                height = tmp;
            }else if(result > arr[tmp]){
                row = tmp;
            }else if(result == arr[tmp]){
                return tmp;
            }
        }

        return 0;
    }
}
