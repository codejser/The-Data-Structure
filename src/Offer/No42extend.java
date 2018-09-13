package Offer;

/**
 * @Author: meteor @Date: 2018/9/13 22:16
 * 剑指Offer42扩展题
 * 对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class No42extend {

    public static void main(String[] args) {
        String s = "abcXYZdef";
        LeftRotateString(s,3);
    }

    /**
     * 思路与42题正好相反
     * 可以根据左移的位数分成两个数组
     * 分别翻转两个数组；
     * 然后翻转整个数组 即可以得到左移后的结果
     * @param str
     * @param n
     * @return
     */
    public static void LeftRotateString(String str,int n) {
        char[] c = str.toCharArray();
        reverse(c,0,n-1);
        reverse(c,n,c.length-1);
        reverse(c,0,c.length-1);
        for (char i:c){
            System.out.print(i);
        }
    }


    private static void reverse(char[] c,int start,int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }
}
