package Offer;

/**
 * @Author: meteor @Date: 2018/9/9 21:04
 *求出任意非负整数区间中1出现的次数
 */
public class No32 {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(5));
    }

    /**
     * 思路:把1-n的每一个数转换成字符数组,然后遍历字符数组与字符1比较
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i=1;i<=n;i++){
            String str = String.valueOf(i);
            char[] c = str.toCharArray();
            for(int j=0;j<c.length;j++){
                if(c[j] == '1'){
                    count++;
                }
            }
        }
        return count;
    }
}
