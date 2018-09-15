package Offer;

/**
 * @Author: meteor @Date: 2018/9/15 14:19
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 * （A?B:C）。
 * 思路参考链接：
 * https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1
 */
public class No46 {

    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
    }


    /**
     * 思路:主要是利用了&&的短路特性 来取代 if ，
     * 如果 &&的左值为false 就不用考虑 右值的情况
     * 计算的逻辑是递归 递归的逻辑就是如果n==0 停止递归 否则 调用 Sum_Solution(--n) 并累加
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }
}
