package Offer;

/**
 * @Author: meteor @Date: 2018/9/13 10:39
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，输出任意一对即可
 */
public class No41 {

    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
        //System.out.println(FindNumbersWithSum(a,15));
        //FindNumbersWithSum1(a,15);
        FindNumbersWithSum2(a,15);
    }

    /**
     * 思路一：循环暴力比较k 复杂度为0(N^2)
     * @param a
     * @param k
     * @return
     */
    private static boolean FindNumbersWithSum(int[] a,int k){
        boolean flag = false;
        for (int i=0;i<a.length;i++){
            for (int j=i;j<a.length;j++){
                if (a[i]+a[j] == k){
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return flag;
    }

    private static void FindNumbersWithSum1(int[] a,int k){
        boolean flag = false;
        for (int i=0;i<a.length;i++){
            for (int j=i;j<a.length;j++){
                if (a[i]+a[j] == k){
                    System.out.println(a[i]+" "+a[j]);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
    }

    /**
     * 优化复杂度;
     * 关键在于题中的数组是有序递增的
     * 思路:用两个指针(左右指针):分别指向数组的左右端(最小值和最大值)
     * 依次将左右指针对应的数据相加
     * 如果和大于k 移动右指针
     * 如果和小于k 移动左指针
     * @param a
     * @param k
     */
    private static void FindNumbersWithSum2(int[] a,int k){
        int i = 0;
        int j = a.length-1;
        while (i<j){
            if (a[i]+a[j]>k){
                j--;
            }else if (a[i]+a[j]<k){
                i++;
            }else {
                System.out.println(a[i] + " " + a[j]);
                i++;
                j--;
            }
        }
    }


}
