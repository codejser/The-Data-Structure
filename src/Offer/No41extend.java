package Offer;

/**
 * @Author: meteor @Date: 2018/9/13 11:04
 * 剑指Offer41题的扩展题
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class No41extend {

    public static void main(String[] args) {
        //System.out.println(gaosi(1,5));
        //FindContinuousSequence(100);
        FindContinuousSequence1(100);
    }

    /**
     * 暴力循环比较 复杂度较高
     * @param k
     */
    private static void FindContinuousSequence(int k){

        int len = (k/2)+1;
        for (int i=1;i<len;i++){
            for (int j=i;j<=len;j++){
                if (gaosi(i,j) == k){
                    for (int n=i;n<=j;n++){
                        System.out.print(n+" ");
                    }
                    System.out.println();
                }
            }
        }

    }

    //高斯公式
    private static int gaosi(int i,int j){
        int count = j-i+1;
        return ((i+j)*count)/2;
    }

    /**
     * 左右指针
     * @param k
     */
    private static void FindContinuousSequence1(int k){
        int i = 1;
        int j = 2;
        int end = (k/2)+1;
        while (i<end){
            if(gaosi(i,j)<k){
                j++;
            }else if (gaosi(i,j)>k){
                i++;
            }else {
                for (int n=i;n<=j;n++){
                    System.out.print(n+" ");
                }
                System.out.println();
                i++;
                j++;
            }
        }
    }
}
