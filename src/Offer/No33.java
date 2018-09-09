package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: meteor @Date: 2018/9/9 21:44
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class No33 {

    public static void main(String[] args) {
        int[] a ={3,32,321};
       System.out.println(PrintMinNumber(a));
    }

    /**
     * 思路就是把数组的元素放入集合中,使用工具类的Collections.sort(list,比较器);
     * 重写比较器的compare方法
     */
    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String str = "";
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }

        Collections.sort(list,new Comparator<Integer>(){

            @Override
            public int compare(Integer s1,Integer s2) {
               String str1 = s1+""+s2;
               String str2 = s2+""+s1;
               return str1.compareTo(str2);
            }
        });
        for (int j:list){
            str+=j;
        }
        return str;
    }

   /* public static String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list=new ArrayList<Integer>();
        n=numbers.length;

        for(int i=0;i<n;i++){
            list.add(numbers[i]);//将数组放入arrayList中
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list,new Comparator<Integer>(){

            @Override
            public int compare(Integer str1, Integer str2) {
                // TODO Auto-generated method stub
                String s1=str1+""+str2;
                String s2=str2+""+str1;

                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s+=j;
        }
        return s;
    }*/
}
