package Offer;

/**
 * @Author: meteor @Date: 2018/9/12 16:31
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 思路:根据异或的结果可以把两个单独出现的数，分到两个数组中，然后根据自身异或为0，求出结果
 */
public class No40 {

    public static void main(String[] args) {
        int[] a = {2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(a);
    }

    /**
     * 主要分为三个步骤：
     * 1.求出输入数组异或的结果
     * 2.求出异或结果二进制位第一次出现1的下标
     * 3.根据下标的位置来将两个数组分开
     * 4.分别求出两个数组的异或结果
     * @param a
     */
    private static void FindNumsAppearOnce(int[] a){
        if (a==null)
            return;
        int num = 0;
        //求出输入数组异或的结果
        for (int i=0;i<a.length;i++){
            num^=a[i];
        }
        int index = FindFirstIndexBit1(num);
        int num1 = 0;
        int num2 = 0;
        for (int i=0;i<a.length;i++){
            if (isBit(a[i],index)){
                num1^=a[i];
            }else
                num2^=a[i];
        }
        System.out.println(num1+" "+num2);
    }

    //判断i的二进制在index的位置上是否为1
    private static boolean isBit(int i, int index) {
        i=i>>index;
        return (i&1)==0;
    }

    //求出异或结果二进制位第一次出现1的下标
    private static int FindFirstIndexBit1(int num) {
        int index = 0;
        while ((num&1)==0){
            num = num>>1;
            index++;
        }
        return index;
    }
}
