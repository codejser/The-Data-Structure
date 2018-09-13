package Offer;

import java.util.Scanner;

/**
 * @Author: meteor @Date: 2018/9/13 14:35
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am student."，则输出"student. am I"
 */
public class No42 {

    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        String s = sc.next();*/
       /* char[] c = s.toCharArray();*/
        /*reverse(c,0,c.length-1);
        for (char i:c){
            System.out.print(i);
        }*/
        String s = "I am student.";
        ReverseSentence(s);
        //reverse(s.toCharArray(),0,s.toCharArray().length-1);
    }


    /**
     * 1.翻转整个句子
     * 2.翻转每个单词
     * @param str
     * @return
     */
    public static void ReverseSentence(String str) {
        char[] c = str.toCharArray();
        reverse(c,0,c.length-1);
        int start = 0;
        int end = 0;

        for (int i=0;i<c.length;i++){
            if (c[i] == ' '){
                reverse(c,start,end-1);
                end++;
                start = end;
            }else {
                end++;
            }
        }
        for (char i:c){
            System.out.print(i);
        }
    }

    /**
     * 翻转整个输入的方法要考虑通用性，可以支持翻转任意范围的字符串(可以翻转单词)
     * @param c
     * @param start
     * @param end
     */
    private static void reverse(char[] c,int start,int end){
            for (int i=start,j=end;i<=j;i++,j--){
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }
      /*  int i = start;
        int j = end;
        while (i<=j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }*/
    }
}
