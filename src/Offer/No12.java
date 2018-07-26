package Offer;

import java.util.Scanner;

/**
 * @Author: meteor @Date: 2018/7/23 19:43
 */
public class No12 {

    public static void main(String[] args) {
        //calc(2);
        printNum(3);
    }

    /**
     * 没有考虑到当n特别大的时候，会出现溢出
     * @param n
     */
    private static void calc(int n){
        int number = 1;
        for(int i=0;i<n;i++)
            number *= 10;

        for(int i=1;i<number;i++){
            if(i != number-1)
                System.out.print(i+",");
            else
                System.out.print(i);
        }
    }

    private static void printNum(int n) {
        if(n<0)
            return;
        int[] array=new int[n];
        printArray(array,0);
    }

    private static void printArray(int[] array, int n) {

        if(n!=array.length){
            for(int i=0;i<10;i++){
                array[n]=i;
                printArray(array, n+1);
            }
        }
        else{
            boolean flag=false;
            for(int j=0;j<array.length;j++){
                if(array[j]!=0){
                    flag=true;
                }
                if(flag){
                    System.out.print(array[j]);
                }
            }
            if(flag)    //去掉空白行
                System.out.println();
        }

    }


}
