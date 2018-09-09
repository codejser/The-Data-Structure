package Offer;

import java.util.Arrays;

/**
 * @Author: meteor @Date: 2018/9/9 10:39
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class No29 {

    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,2,5,4,2};
        System.out.println(findNum1(arr));
        System.out.println(findNum1(arr));
    }

    /**
     * 思路一:利用Arrays的静态方法sort()进行排序，根据题意可知arr[n/2]为重复的值
     * 然后在判断重复的值的次数是否符合题意(出现的次数超过一半)
     * 时间复杂度为O(nlogn),原因是调用了Java的API Arrays.sort(arr);底层为快排
     * @param arr
     * @return
     */
    private static Integer findNum1(int[] arr){
        int len = arr.length;
        //参数校验
        if (len<0){
            return 0;
        }
        //排序：从小到大
        Arrays.sort(arr);
        //重复的数字
        int num = arr[len/2];
        //出现的次数
        int count = 0;
        for (int i=0;i<len;i++){
            if (num == arr[i]){
                count++;
            }
        }
        //如果出现的次数小于一半，则表明不存在
        if (count<=(len/2)){
            return 0;
        }
        return num;
    }
    /**
     * 思路二:时间复杂度为O(n)
     * @param arr
     * @return
     */
    private static Integer findNum2(int[] arr) {
        if(arr==null)
            return  null;

        int result=arr[0];
        int count=1;

        for(int i=1;i<arr.length;i++){
            if(count==0){
                result=arr[i];
                count=1;
            }
            else if(arr[i]==result){
                count++;
            }
            else{
                count--;
            }
        }
        return result;
    }
}

