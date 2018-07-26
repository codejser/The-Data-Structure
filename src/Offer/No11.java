package Offer;

/**
 * @Author: meteor @Date: 2018/7/23 18:39
 * 剑指Offer第11题：
 * 实现函数double Power(double base,int exponent)，
 * 求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 */
public class No11 {

    /**
     * 不考虑任何细节的解法
     * 指数等于0或者为负数
     * 底数等于0
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base,int exponent){
        double result = 1.0;
        for (int i = 1;i<=exponent;i++){
            result *= base;
        }
        return result;
    }

    /**
     * 考虑细节的解法
     * @param base
     * @param exponent
     * @return
     */
    public static double Power1(double base,int exponent){
        double result = 0.0;
        //如果底数为0
        if(base == 0)
            return 0.0;
        //如果指数为0
        if(exponent == 0)
            return 1.0;
        //如果指数小于0
        int ex = 0;
        if(exponent < 0) {
            ex = -exponent;
            return 1.0 / Power2(base, ex);
        }
        return  Power2(base,exponent);

    }

    /**
     * 优化Power函数
     * @param base
     * @param exponent
     * @return
     */
    public static double Power2(double base,int exponent){
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result = Power2(base,exponent >> 1);
        result *=result;
        if(exponent % 2 !=0)
            result *= base;
        return result;
    }




    public static void main(String[] args) {
        //System.out.println(No11.Power(2,4));
        //System.out.println(No11.Power1(5,-1));
        System.out.println(No11.Power1(5,-1));
        System.out.println(No11.Power1(2,3));
    }
}
