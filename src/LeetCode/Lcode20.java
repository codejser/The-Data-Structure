package LeetCode;


import java.util.Stack;

/**
 * @Author: meteor @Date: 2018/7/15 13:50
 * LeetCode20:括号匹配(栈的应用)
 */
public class Lcode20 {

    private static boolean valid(String s){
        //用栈来存放需要匹配的括号字符
        Stack<Character> stack = new Stack<Character>();

        //遍历给定的字符串，进行匹配
        for(int i = 0; i < s.length();i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                //取当前的栈顶元素，与当前遍历到的字符进行匹配
                char topC = stack.pop();
                if(c == ')' && topC != '(' ){
                    return false;
                }
                if(c == '}' && topC != '{' ){
                    return false;
                }
                if(c == ']' && topC != '[' ){
                    return false;
                }
            }
        }
        //遍历比较之后，栈仍然有值，不匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "{[()]}";
        String s2= "{[({]}";
        String s3= "{[({]}{";
        System.out.println(valid(s1));
        System.out.println(valid(s2));
        System.out.println(valid(s3));
    }

}
