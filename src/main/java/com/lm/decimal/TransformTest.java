package com.lm.decimal;

import com.lm.design.action.strategy.Strategy;
import org.junit.Test;

/**
 * 十进制转二进制
 * 二进制转十进制
 * 十进制转16进制
 * @Author: limeng
 * @Date: 2019/6/15 15:50
 */
public class TransformTest {
    /*------------------------------------- 十转二*/

    /**
     *
     */
    public void binaryToDecimal1(int n){
        int t=0; //记录位数
        int bin=0; //记录最后二进制数
        int r = 0; //存储余数
        while(n != 0){
            r = n % 2;
            n = n/2;
            bin += r * Math.pow(10,t);
            t++;
        }
        System.out.println(bin);
    }

    public void binaryToDecimal2(int n){
        String str = "";
        while (n != 0){
            str = n%2 + str;
            n = n/2;
        }
        System.out.println(str);
    }

    public void binaryToDecimal3(int n){
        for (int i = 31;i>=0;i--)
            System.out.print(n >>> i & 1);
    }

    public void binaryToDecimal4(int n){
        String s = Integer.toBinaryString(n);
        System.out.println(s);
    }
    /*------------------------------------- 二转十*/
    public void binaryToDecimal5(String n){
        int i = Integer.parseInt(n, 2);
        System.out.println(i);
    }

    public void binaryToDecimal6(int n){
        int decimal = 0;
        int p =0;
        while (true){
            if(n == 0){
                break;
            }else{
                int tmp = n % 10;
                decimal += tmp * Math.pow(2,p);
                n  = n / 10;
                p ++;
            }
        }
        System.out.println(decimal);
    }

    @Test
    public void initBinary(){
        //11111111111111111111111111111100
        //binaryToDecimal4(-4);
        //binaryToDecimal5("11111111111111111111111111111100");
    }

    /*------------------------------------- 十进制转16进制*/

    public void hexToString1(int n){
        int yu = 0;
        int tmp = n;
        String s="";
        while (tmp != 0){
            yu = tmp % 16;
            tmp = tmp / 16;

            char result;
            if(yu >= 9){
                result = (char)('A'+(yu - 10));
            }else{
                result = (char)('0'+(yu - 0));
            }
            s = result + s;
        }
        System.out.println(s);
    }

    // 十进制转换为 n 进制
    public void fun(int n,int num) {
        String str= "";
        int yushu;
        int shang = num;
        while (shang > 0){
            yushu = shang % n;
            shang = shang / n;

            if(yushu > 9){
                str = (char)('A' + (yushu - 10)) + str;
            }else{
                str = yushu + str;
            }
        }

        System.out.println(str);
    }

    @Test
    public void initHex(){
        //hexToString1(20);
        fun(8,20);
    }


}
