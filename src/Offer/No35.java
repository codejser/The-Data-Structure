package Offer;

import java.util.LinkedHashMap;

/**
 * @Author: meteor @Date: 2018/9/10 11:04
 * 在字符串中找出第一个只出现一次的字符。
 * 如输入"abaccdeff"，则输出'b'
 */
public class No35 {

    public static void main(String[] args) {
        //String s = "acbeff";
        //System.out.println(FirstNotRepeatingChar(s));
        //Map<String,Integer> hash = new HashMap<String, Integer>();
       /* LinkedHashMap<String,Integer> hash = new LinkedHashMap<String, Integer>();
        hash.put("+",1);
        hash.put("#",2);
        hash.put("$",3);
        for (String key:hash.keySet()){
            System.out.println(key);
        }*/
    }

    /**
     * 思路:把字符串转换成字符数组、放入Map中，字符为键，值为出现的次数
     * 使用LinkedHashMap的原因是放入的顺序与取出的顺序是相同的，符合第一次出现的题意
     * @param str
     * @return
     */
    public static Character FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> hash = new LinkedHashMap<Character, Integer>();
        //Map<Character,Integer> hash = new LinkedHashMap<Character, Integer>();
        char[] c = str.toCharArray();
        for (char item : c){
            if (hash.containsKey(item)){
                hash.put(item,hash.get(item)+1);
            }else {
                hash.put(item,1);
            }
        }
        for (char key:hash.keySet()){
            if (hash.get(key) == 1){
                return key;
            }
        }
        return null;
    }

}
