package com.lm.sort;

import com.lm.util.Example;
import org.junit.Test;

/**
 * 快速排序
 * @Author: limeng
 * @Date: 2019/6/10 9:39
 */
public class QuickSort extends Example {

    protected int partition(Comparable[] a,int lo,int hi){
        int i = lo;
        int j = hi+1;

        Comparable v =a[i];
        while (true){
            //扫描左
            while (this.less(a[++i],v))  if(i == hi) break;
            while (this.less(v,a[--j]))  if(j == lo) break;
            if(i >= j) break;
            this.exch(a,i,j);
        }
        this.exch(a,lo,j);
        return j;
    }
    @Override
    protected void sort(Comparable[] a) {
       this.sort(a,0,a.length-1);
    }

    protected void sort(Comparable[] a,int lo,int hi) {
        if(hi <= lo) return;

        int j = this.partition(a,lo,hi);
        this.sort(a,lo,j-1);
        this.sort(a,j+1,hi);
    }
    @Test
    public void init(){
        Comparable[] a={10,40,30,20,45,55,66};
        this.sort(a);
        this.show(a);
    }
}
