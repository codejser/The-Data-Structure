package Offer;

/**
 * @Author: meteor @Date: 2018/9/8 23:11
 *  输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc， 则打印出由字符串a、b、c所能
 * 排列出来的所有字符串abc、acb、bac、bca、cab和cba
 */
public class Offer28 {
    public static void main(String[] args) {
        myPrint("abc");
    }

    private static void myPrint(String str) {
        if(str==null)
            return;
        char[] chs=str.toCharArray();
        myPrint(chs,0);
    }

    private static void myPrint(char[] str, int i) {
        //终止条件
        if (i >= str.length)
            return;
        //当下标来到最后一位时，表明已经排好序，输出即可，也是递归的出口
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                //交换位置
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                //递归开始
                myPrint(str, i + 1);

                //退出递归时需要还原之前的排序abc/防止出现重复的输出
               temp = str[j];
               str[j] = str[i];
               str[i] = temp;
            }
        }
    }

}
