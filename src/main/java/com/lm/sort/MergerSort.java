package com.lm.sort;

import com.lm.util.Example;
import org.junit.Test;

/**
 * @Author: limeng
 * @Date: 2019/6/10 10:21
 */
public class MergerSort extends Example {
    private Comparable[] aux;

    @Override
    protected void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        this.sort(a,0,a.length-1);
    }
    protected void sort(Comparable[] a,int lo,int hi){
        if(hi >= lo) return;
        int mid = lo + (hi-lo)/2;
        this.sort(a,lo,mid);
        this.sort(a,mid+1,hi);
        this.merge(a,lo,mid,hi);
    }

    /**
     * 合并子数组
     * @param a
     * @param lo 开始
     * @param mid 中间
     * @param hi 结尾
     */
    protected void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<= hi ; k++){
            aux[k] = a[k];
        }

        /**
         * 子序列
         * i 左边用尽，取右边
         * j 右边用尽，取左边
         * j i比大小   j小  赋值k数值 ，反之亦然
         */
        for (int k = lo; k <= hi; k++) {
            if(i > mid){
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if(this.less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
    }

    @Test
    public void init() {
        Comparable[] a = {10, 40, 30, 2};
        this.sort(a);
        this.show(a);
    }
}
