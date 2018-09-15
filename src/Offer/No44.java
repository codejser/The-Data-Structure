package Offer;

import java.util.Arrays;

/**
 * @Author: meteor @Date: 2018/9/15 10:15
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。2~10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字(这里可以看成0)
 */
public class No44 {

    public static void main(String[] args) {
        int[] a = {0,4,6,0};
        System.out.println(isContinuous(a));
    }

    public static boolean isContinuous(int [] a) {
        if (a == null && a.length == 0){
            return false;
        }
        //出现0的次数
        int countZero = 0;
        //需要填补的数量
        int countNeed = 0;
        Arrays.sort(a);
        for (int i=0;i<a.length;i++){
            if (a[i] == 0)
            countZero++;
        }
        //双指针来判断是否为顺子
        //排序后第一个非零数字下标
        int small = countZero;
        int big = small+1;
        while (big<a.length){
            //如果后一个数字与前一个数字重复出现，说明不是顺子
            if (a[big] == a[small]){
                return false;
            }
            //计算剩余非零数字需要填补的次数
            countNeed += a[big] - a[small] - 1;
            small = big;
            big++;
        }
        return (countNeed>countZero)?false:true;
    }
}
