package Offer;

/**
 * @Author: meteor @Date: 2018/9/9 20:59
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，
 */
public class No31 {

    public static void main(String[] args) {
        int[] a ={6,-3,-2,7,-15,1,2,2};
        System.out.println( FindGreatestSumOfSubArray(a));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = 0;
        for(int i=0;i<array.length;i++){
            sum=array[i];
            if(sum>max){
                max = sum;
            }
            for(int j=i+1;j<array.length;j++){
                sum+=array[j];
                if(sum>max){
                    max = sum;
                }
            }
        }
        return max;
    }
}
